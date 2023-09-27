package Fundamentals2;

public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        String a = Integer.toString(Math.abs(number));
        String b = a.substring(0, a.length() / 2) + a.substring(a.length() / 2, a.length());
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != b.charAt(b.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
