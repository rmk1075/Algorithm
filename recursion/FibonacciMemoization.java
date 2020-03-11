package recursion;

import java.util.Scanner;

public class FibonacciMemoization {
    static long[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        memo = new long[N+1];
        memo[0] = 0;
        memo[1] = 1;
        
        System.out.println(fibo(N));
    }

    private static long fibo(int n) {
        if(memo[n] != 0) return memo[n];

        if (n <= 1) return n;
        return memo[n] = (fibo(n - 1) + fibo(n - 2));
    }
}