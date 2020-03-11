package combination;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
    static int N, R, totalCnt;
    static int[] input, number; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        number = new int[R];

        for(int i = 0; i < N; i++) input[i] = sc.nextInt();
        sc.close();

        combination(0, 0);
        System.out.println("total count: " + totalCnt);
    }

    private static void combination(int count, int current) {
        if(count == R) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return ;
        }

        for(int i = current; i < N; i++) {
            number[count] = input[i];
            combination(count+1, i+1);
        }
    }
}