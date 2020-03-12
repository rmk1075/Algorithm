package combination;

import java.util.Arrays;
import java.util.Scanner;

public class Dice {
    static int N, M, totalCnt = 0, number[];
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        number = new int[N];
        isSelected = new boolean[7];

        switch(M) {
            case 1:
                dice1(0);
                break;
            case 2:
                dice2(0);
                break;
            case 3:
                dice3(0, 1);
                break;
            case 4:
                dice4(0, 1);
        }

        System.out.println("total Cnt: " + totalCnt);
    }

    // multiset permutation
    private static void dice1(int count) {
        if(count == N) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return ;
        }

        for(int i = 1; i <= 6; i++) {
            number[count] = i;
            dice1(count + 1);
        }
    }

    // permutation
    private static void dice2(int count) {
        if(count == N) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return ;
        }

        for(int i = 1; i <= 6; i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            number[count] = i;
            dice2(count + 1);
            isSelected[i] = false;
        }
    }

    // multiset combination
    private static void dice3(int count, int current) {
        if(count == N) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return ;
        }

        for(int i = current; i <= 6; i++) {
            number[count] = i;
            dice3(count + 1, i);
        }
    }

    // combination
    private static void dice4(int count, int current) {
        if(count == N) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return ;
        }

        for(int i = current; i <= 6; i++) {
            number[count] = i;
            dice4(count + 1, i + 1);
        }
    }
}