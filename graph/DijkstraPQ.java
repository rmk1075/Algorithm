package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraPQ {
    static class Edge implements Comparable<Edge> {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }

        @Override
        public String toString() {
            return w+"";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < E; i++) adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
        sc.close();

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V];
        Edge[] D = new Edge[V];
        for(int i = 0; i < V; i++) {
            if(i == 0) D[i] = new Edge(i, 0);
            else D[i] = new Edge(i, Integer.MAX_VALUE);
            pq.offer(D[i]);
        }

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            for(Edge next : adj[edge.v]) {
                if(!check[next.v] && D[edge.v].w + next.w < D[next.v].w) {
                    D[next.v].w = D[edge.v].w + next.w;
                    pq.remove(D[next.v]);
                    pq.offer(D[next.v]);
                }
            }
            check[edge.v] = true;
        }
        System.out.println(Arrays.toString(D));
    }
 }