package recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        System.out.println(factorial(N));
    }

    private static int factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}