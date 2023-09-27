package Fundamentals2;

public class FirstAndLastDigitSum {
    public static int sumFirstAndLastDigit(int number){
        String n = Integer.toString((number));
        return number<0 ? -1 : Integer.parseInt(String.valueOf(n.charAt(0))) + Integer.parseInt(String.valueOf(n.charAt(n.length()-1)));
    }
}
