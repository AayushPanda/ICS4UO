package DSA;

import java.util.Arrays;

public class StupidSort {
    public static int[] sort(int[] arr){
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            int min = arr[0];
            int minIndex = 0;
            for (int j = 0; j < arr.length; j++){
                if (arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            sorted[i] = min;
            arr[minIndex] = Integer.MAX_VALUE;
        }
        return sorted;
    }
    public static void main(String[] args) {
        int[] toSort = {5,3,3,5,6,4,3,2,7,9,7};
        System.out.println(Arrays.toString(sort(toSort)));
    }
}
