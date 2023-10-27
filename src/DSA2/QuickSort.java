package DSA2;

import java.util.Arrays;

public class QuickSort {

    private static int ctr = 0;

    public static int[] genNumList(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        return arr;
    }

    public static int[] shuffle(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int j = (int)(Math.random() * arr.length);
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = shuffle(genNumList(12));
        System.out.println("Original: " + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("Steps: "  + ctr);
        ctr = 0;
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
    
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int lBound = low - 1;
        for(int j = low; j < high; j++){
            ctr++;
            if(arr[j] < pivot){
                lBound++;
                int t = arr[lBound];
                arr[lBound] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[lBound + 1];
        arr[lBound + 1] = arr[high];
        arr[high] = t;
        return lBound + 1;
    }

    public static void sort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

}
