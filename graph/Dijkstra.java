package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * priorityQueue를 사용한 dijkstra 알고리즘
 * 무향, 유향 상관없이 모든 graph 지원
 * 음의 값이 있는 graph는 사용할 수 없다.
 */

public class Dijkstra {
    static int INF = Integer.MAX_VALUE;
    int[] nodes;
    ArrayList<Node>[] edges;
    PriorityQueue<Node> pq = new PriorityQueue<>();

    Dijkstra(int numOfNodes, int src, ArrayList<Node>[] edges) {
        nodes = new int[numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) nodes[i] = INF;
        nodes[src] = 0;

        this.edges = edges;

        pq.offer(new Node(src, 0));
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            for(Node edge : edges[curNode.idx]) {
                if(nodes[edge.idx] <= curNode.distance + edge.distance)
                    continue;

                nodes[edge.idx] = curNode.distance + edge.distance;
                pq.offer(new Node(edge.idx, nodes[edge.idx]));
            }
        }

        for(int i = 1; i <= numOfNodes; i++) {
            System.out.println(i + ": " + ((nodes[i] == INF) ? "INF" : nodes[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adj = new int[V][V];
        for(int i = 0; i < E; i++) adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();

        int[] D = new int[V];
        Arrays.fill(D, INF);
        boolean[] check = new boolean[V];

        D[0] = 0;
        for(int i = 0; i < V-1; i++) {
            int min = INF;
            int idx = -1;
            for(int j = 0; j < V; j++) {
                if(!check[j] && D[j] < min) {
                    min = D[j];
                    idx = j;
                }
            }

            for(int j = 0; j < V; j++) {
                if(!check[j] && adj[idx][j] != 0 && D[idx] + adj[idx][j] < D[j]) D[j] = D[idx] + adj[idx][j];
            }
            check[idx] = true;
        }

        System.out.println(Arrays.toString(D));
        sc.close();
    }
}