package recursion;

import java.util.Scanner;

public class Hanoi {
    static int totalCnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        hanoi(N, 1, 2, 3);
        System.out.println(sb.toString());
        System.out.println("total count: " + totalCnt);
    }

    private static void hanoi(int cnt, int from, int temp, int to) {
        if(cnt == 0) return ;

        hanoi(cnt-1, from, to, temp);
        totalCnt++;
        sb.append(cnt + ":" + from + "->" + to +"\n");
        hanoi(cnt-1, temp, from, to);
    }
}