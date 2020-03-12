package subset;

import java.util.Scanner;

public class BinaryCounting {
    static int N, totalCnt, input[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        input = new int[N];
        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        totalCnt = 1 << N;
        subset(totalCnt);
        System.out.println("total count: " + totalCnt);
    }

    private static void subset(int caseCnt) {
        for(int flag = 0; flag < caseCnt; flag++) {
            for(int i = 0; i < N; i++) {
                System.out.print(((flag & (1 << i)) == 0) ? "X\t" : i + "\t");                
            }
            System.out.println();
        }
    }
}