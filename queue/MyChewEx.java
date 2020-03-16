package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyChewEx {
    public static void main(String[] args) {
        int N = 10, idx = 1;
        Queue<int[]> queue = new LinkedList<>(); // [0]: idx, [1]: cnt
        queue.offer(new int[] {idx++, 1});

        while(0 < N) {
            int availableCnt;
            if(!queue.isEmpty()) {
                int[] p = queue.poll();
                availableCnt = (p[1] <= N) ? p[1] : N;
                N -= availableCnt;
                if(N == 0) System.out.println("last idx: " + p[0] + ", cnt: " + availableCnt);
                else {
                    System.out.println("idx: " + p[0] + ", cnt: " + p[1]);
                    p[1]++;
                    queue.offer(p);
                    queue.offer(new int[] {idx++, 1});
                }
            }
        }

    }
}