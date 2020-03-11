import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitmask {
    static int N, R, totalCnt;
    static int[] input, number;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        number = new int[R];

        for (int i = 0; i < N; i++)
            input[i] = sc.nextInt();

        permutation(0, 0);
        System.out.println("total count : " + totalCnt);
    }

    static void permutation(int count, int flag) {
        if (count == R) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) continue;

            number[count] = input[i];
            flag |= (1 << i);
            permutation(count + 1, flag);
        }
    }
}