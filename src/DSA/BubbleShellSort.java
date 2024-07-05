package DSA;

public class BubbleShellSort {
    public static int bubbleSort(int[] arr){
        int ctr = 0;
        for(int i = arr.length - 1; i >= 1; i--){
            boolean swapped = false;
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    swapped = true;
                }
                ctr++;
                if(!swapped) break;
            }
        }
        return ctr;
    }

    public static int bbShellSort(int[] arr){
        int ctr = 0;
        for(int gap = arr.length/2; gap>=1; gap/=2){
            for(int i = arr.length - gap; i >= gap; i--){
                boolean swapped = false;
                for(int j = 0; j < i; j++){
                    if(arr[j] > arr[j+gap]){
                        int t = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = t;
                    }
                    ctr++;
                    if(!swapped) break;
                }
            }
        }
        return ctr;
    }

    public static int[] genNumList(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static void shuffle(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int j = (int)(Math.random() * arr.length);
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] arr = genNumList(1000);
        shuffle(arr);
        int[] arr2 = arr;
        System.out.println("Steps taken by BBSort: " + bubbleSort(arr));
        ///System.out.println(java.util.Arrays.toString(arr));
        System.out.println("Steps taken by BBShellSort: " + bbShellSort(arr2));
        //System.out.println(java.util.Arrays.toString(arr2));
    }
}