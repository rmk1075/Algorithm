import java.util.Arrays;
import java.util.Scanner;

public class PermutationBooleanArrays {
    static int N, R, totalCnt;
    static int[] input, number;
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        number = new int[R];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i++) 
            input[i] = sc.nextInt();
        
        permutation(0);
        System.out.println("total count : " + totalCnt);
    }

    static void permutation(int count) {
        if(count == R) {
            totalCnt++;
            System.out.println(Arrays.toString(number));           
            return ;
        }

        for(int i = 0; i < N; i++) {
            if(isSelected[i]) continue;

            number[count] = input[i];
            isSelected[i] = true;
            permutation(count+1);
            isSelected[i] = false;
        }
    }
}