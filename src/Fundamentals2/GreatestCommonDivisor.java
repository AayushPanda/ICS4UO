package Fundamentals2;

import java.util.*;

public class GreatestCommonDivisor {
    public static int twoGCD(int a, int b){
        // uses the Euclidean division method
        int c;
        while(b > 0){
            c=b;
            b=a%b;
            a=c;
        }
        return a;
    }
    public static int getGreatestCommonDivisor(int... n){
        for (int a : n){
            if(a<0){
                return -1;
            }
        }

        while(n.length>1){
            n[1] = twoGCD(n[0], n[1]);
            n = Arrays.copyOfRange(n, 1, n.length);
        }
        return n[0];
    }
    public static void main(String[] args){
        System.out.println(getGreatestCommonDivisor(25, 15, 55));
    }
}
