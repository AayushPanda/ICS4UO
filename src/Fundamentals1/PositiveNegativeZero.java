package Fundamentals1;

public class PositiveNegativeZero {
    public static String checkNumber(int n){
        if (n==0) {
            return "zero";
        } else if(n>0) {
            return "positive";
        } else {
            return "negative";
        }
    }
}
