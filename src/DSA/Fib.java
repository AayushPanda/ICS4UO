package DSA;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n){
        if(n==0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        } else{
            return fib(n-1)+fib(n-1);
        }
    }
}
