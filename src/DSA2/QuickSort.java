package DSA2;

import java.util.Arrays;

public class QuickSort {

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
        System.out.println(Arrays.toString(sort(arr, 0, arr.length-1)));
    }

    public static int[] sort(int[] arr, int left, int right){
        int pivot = arr.length-2;
        int pivotVal = arr[pivot];

        while(left<right){
            if(arr[left]<pivo
        }
    }
    
}
