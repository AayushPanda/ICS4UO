package DSA2;

import java.util.Arrays;

public class MergeSort {
    private static int ctr = 0; // Counter for operations

    public static int[] genNumList(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = shuffle(genNumList(12));
        int[] sortedArr = sort(arr);
        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Number of operations: " + ctr);
        System.out.println("Sorted: " + Arrays.toString(sortedArr));
    }

    public static int[] sort(int[] arr) {
        ctr = 0; // Reset the operation count
        return mergeSort(arr);
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < arr.length; i++) {
            if (i < mid) {
                left[i] = arr[i];
            } else {
                right[i - mid] = arr[i];
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftCursor = 0;
        int rightCursor = 0;
        int maxCursor = 0;

        while (leftCursor < left.length && rightCursor < right.length) {
            if (left[leftCursor] < right[rightCursor]) {
                result[maxCursor] = left[leftCursor];
                leftCursor++;
            } else {
                result[maxCursor] = right[rightCursor];
                rightCursor++;
            }
            maxCursor++;
            ctr++; // Count the comparison and assignment operations
        }

        while (leftCursor < left.length) {
            result[maxCursor] = left[leftCursor];
            leftCursor++;
            maxCursor++;
            ctr++; // Count the assignment operations
        }

        while (rightCursor < right.length) {
            result[maxCursor] = right[rightCursor];
            rightCursor++;
            maxCursor++;
            ctr++; // Count the assignment operations
        }

        return result;
    }
}
