package subset;

import java.util.Scanner;

public class Subset {
    static int N, totalCnt;
    static int[] input;
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        input = new int[N];
        isSelected = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        subset(0);
        System.out.println("total count: " + totalCnt);
    }

    private static void subset(int cnt) {
        if(cnt == N) {
            totalCnt++;
            for(int i = 0; i < N; i++) {
                if(isSelected[i]) System.out.print(i+1 + "\t");
                else System.out.print("X\t");
            }
            System.out.println();
            return ;
        }

        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);
    }
}