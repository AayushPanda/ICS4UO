package Fundamentals1;

import java.util.*;

public class IntEqualityPrinter {
    public static void printEqual(int... n){
        int state = 0;

        Set<Integer> s = new HashSet<>();
        for (int value : n) {
            s.add(value);
        }
        
        if (s.size() == 1){
            state = 2;
        } else if (s.size() < n.length){
            state = 1;
        }

        switch (state){
            case 0:
                System.out.println("All numbers are different");
                break;
            case 1:
                System.out.println("Neither all are equal or different");
                break;
            case 2:
                System.out.println("All numbers are equal");
                break;
        }

    }
}
