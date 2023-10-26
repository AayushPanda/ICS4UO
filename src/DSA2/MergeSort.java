package DSA2;

import java.util.Arrays;

public class MergeSort {

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
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        
        int mid = arr.length/2;
        int[] l = new int[mid];
        int[] r = new int[arr.length-mid];

        for(int i = 0; i<arr.length; i++){
            if(i<mid){
                l[i] = arr[i];
            } else {
                r[i-mid] = arr[i];
            }
        }
        l = sort(l);
        r = sort(r);

        return merge(l,r);
    }

    public static int[] merge(int[] l, int[] r){
        int[] result = new int[l.length+r.length];
        int lCursor = 0;
        int rCursor = 0;
        int maxCursor = 0;

        while(lCursor<l.length && rCursor<r.length){
            if(l[lCursor]<r[rCursor]){
                result[maxCursor] = l[lCursor];
                lCursor++;
            } else {
                result[maxCursor] = r[rCursor];
                rCursor++;
            }
            maxCursor++;
        }

        while(lCursor<l.length){
            result[maxCursor] = l[lCursor];
            lCursor++;
            maxCursor++;
        }

        while(rCursor<r.length){
            result[maxCursor] = r[rCursor];
            rCursor++;
            maxCursor++;
        }

        return result;
    }
}
