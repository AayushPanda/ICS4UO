package Fundamentals1;

import java.util.*;

public class jp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int a = 1; a <= 5; a++) {
            long x = sc.nextInt();
            if (x==0){
                System.out.println("1");
            } else {
                double power = Math.round((Math.log(x) / Math.log(2)));
                System.out.println((int)Math.pow(2, power));
            }
        }
    }
}