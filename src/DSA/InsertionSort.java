package DSA;

public class InsertionSort {
    public static void main(String[] args) {
        int[] toSort = {5, 9, 4, 7, 3, 8, 2, 6, 1};
        System.out.println(sort(toSort));
        System.out.println(java.util.Arrays.toString(toSort));

    }
    public static int sort(int[] arr){
        // Time Complexity: O(n^2) - Eventually, on a worst case input, algo loops through the whole array for every element in array = n*n computations
        // Space Complexity: O(1) - No extra space is used, as sort is done in place
        int ctr = 0;
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i;
            ctr++;
            boolean firstPass = true;
            while (j > 0 && arr[j-1] > temp){
                if(firstPass){
                firstPass = false;
                } else {
                    ctr++;
                }
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return ctr;
    }
}
