package DSA;

import java.util.Arrays;
import java.lang.Math;

public class ShellSort {
    public static int sort(int[] arr){
        // Shellsort with halving gap sequence, with comments on every line
        int n = arr.length;
        int ctr = 0;
        int gap = n/2; // Start with a big gap, then reduce the gap
        while (gap > 0){
            System.out.println("-------------");
            System.out.println("Gap:= " + gap);
            for (int i = gap; i < n; i++){
                int temp = arr[i]; // Store a value in the gap
                System.out.println("Temp:= " + temp);
                int j = i; // Shift earlier gap-sorted elements up until the correct location for a[i] is found
                boolean flag = false;
                while (j >= gap && arr[j - gap] > temp){
                    arr[j] = arr[j - gap];
                    String output = "";
                    // //Print array with ** flanking swapped elements
                    output += (ctr + ": ");
                    output += ("Swap [" + (j - gap) + "] and [" + j + "]: ");
                    // Print elements until first swapped element, but not including it
                    output += (java.util.Arrays.toString(Arrays.copyOfRange(arr, 0, j - gap)).replace("[", "").replace("]", ""));
                    // Print first swapped element flanked by **s
                    output += (", **" + arr[j - gap] + "**, ");
                    // Print elements after first swapped element, until second swapped element, but not including it
                    output += (java.util.Arrays.toString(Arrays.copyOfRange(arr, j - gap + 1, j)).replace("[", "").replace("]", ""));
                    // Print second swapped element flanked by **s
                    output += (", **" + arr[j] + "**, ");
                    // Print elements after second swapped element
                    output += (java.util.Arrays.toString(Arrays.copyOfRange(arr, j + 1, arr.length)).replace("[", "").replace("]", ""));
                    System.out.println(output.replace(", ,", ",").replace(" ,", ""));

                    j -= gap;

                    // To avoid overcounting on first comparision
                    if(!flag){
                        flag = true;
                    } else {
                        ctr++;
                    }

                }
                arr[j] = temp; // Put temp (the original a[i]) in its correct location
                System.out.print(ctr + ": ");
                System.out.print("Set  [" + (j) + "] to temp: ");
                // System.out.println(java.util.Arrays.toString(arr).replace("[", "").replace("]", ""));
                String output = "";
                output += (java.util.Arrays.toString(Arrays.copyOfRange(arr, 0, Math.max(0, j-1))).replace("[", "").replace("]", ""));
                output += (", **" + arr[j] + "**, ");
                output += (java.util.Arrays.toString(Arrays.copyOfRange(arr, j + 1, arr.length)).replace("[", "").replace("]", ""));
                System.out.println(output.replace(", ,", ",").replace(" ,", " "));
                ctr++;
            }
            gap /= 2; // Reduce the gap
        }
        return ctr;
    }

    public static int quietSort(int[] arr){
        // Shellsort with halving gap sequence, with comments on every line
        int n = arr.length;
        int ctr = 0;
        int gap = n/2; // Start with a big gap, then reduce the gap
        while (gap > 0){
            for (int i = gap; i < n; i++){
                int temp = arr[i]; // Store a value in the gap
                int j = i; // Shift earlier gap-sorted elements up until the correct location for a[i] is found
                boolean flag = false;
                while (j >= gap && arr[j - gap] > temp){
                    arr[j] = arr[j - gap];
                    j -= gap;
                    if(!flag){
                        flag = true;
                    } else {
                        ctr++;
                    }
                }
                arr[j] = temp; // Put temp (the original a[i]) in its correct location
                ctr++;
            }
            gap /= 2; // Reduce the gap
        }
        return ctr;
    }
    public static void main(String[] args) {
        int[] arr = {5, 9, 4, 7, 3, 8, 2, 6, 1};       
        // System.out.println(java.util.Arrays.toString(arr));
        int steps = sort(arr);
        // System.out.println("");
        // System.out.print("Sorted: ");
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println("Steps taken: " + steps);
    }
}