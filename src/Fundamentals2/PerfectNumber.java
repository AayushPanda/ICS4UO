package Fundamentals2;

public class PerfectNumber {
    public static boolean isPerfectNumber(int number){
        int sum = 1;
        for(int i=2; i<=(int)Math.sqrt(number); i++){
            if(number%i==0){
                sum += i;
                sum += (number/i==i ? 0 : number/i);
            }
        }
        return sum==number;
    }
}
