package takeyoufwd.basicmath;
/*
each number in fibonacci series is sum of last 2 numbers, here you need to find nth fib number
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(f(8));
    }
    static int f(int n) {
        if(n<=1) return n;
        return f(n-1)+f(n-2);
    }
}
