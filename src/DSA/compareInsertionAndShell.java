package DSA;

import java.util.Arrays;

public class compareInsertionAndShell {
    
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
        int[] arr = genNumList(100);
        shuffle(arr);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println("Steps taken by InsertionSort: " + InsertionSort.sort(arr));
        ///System.out.println(java.util.Arrays.toString(arr));
        System.out.println("Steps taken by ShellSort: " + ShellSort.quietSort(arr2));
        //System.out.println(java.util.Arrays.toString(arr2));
    }
}
