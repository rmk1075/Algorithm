package permutation;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    static int N, totalCnt;
    static int[] input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        for(int i = 0; i < N; i++) input[i] = sc.nextInt();

        // sequence: smallest number -> biggest number
        Arrays.sort(input);
        do {
            System.out.println(Arrays.toString(input));
        } while(nextPermutation());
        
        System.out.println("total count: " + totalCnt);
    }

    private static boolean nextPermutation() {
        totalCnt++;

        // step1: find i
        int i = N-1;
        while(0 < i && input[i] <= input[i-1]) i--;
        if(i == 0) return false; // maximum number

        // step2: find j
        int j = N-1;
        while(input[j] <= input[i-1]) j--;

        // step3: swap input[i-1] and input[j]
        int temp = input[j];
        input[j] = input[i-1];
        input[i-1] = temp;

        // step4: sort i ~ N-1
        int k = N-1;
        while(i < k) {
            temp = input[i];
            input[i] = input[k];
            input[k] = temp;
            i++;
            k--;
        }

        return true;
    }
}