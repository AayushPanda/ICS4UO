package DSA;

public class InsertionSort {
    public static void main(String[] args) {
        int[] toSort = {5,3,3,5,6,4,3,2,7,9,7};
        sort(toSort);
        System.out.println(java.util.Arrays.toString(toSort));
    }
    public static void sort(int[] arr){
        // Time Complexity: O(n^2) - Eventually, on a worst case input, algo loops through the whole array for every element in array = n*n computations
        // Space Complexity: O(1) - No extra space is used, as sort is done in place
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
