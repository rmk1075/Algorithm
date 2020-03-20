package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjList {
    
    static class Node {
        int to;
        Node link; // next

        Node(int to, Node link) {
            this.to = to;
            this.link = link;
        }

        Node(int to) {
            this.to = to;
        }
    }

    private static int N;
    private static Node[] adjList;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // num of nodes
        int M = sc.nextInt(); // num of edges
        adjList = new Node[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }
        sc.close();

        System.out.println("dfs");
        dfs(1);

        System.out.println();
        Arrays.fill(visited, false);

        System.out.println("bfs");
        bfs(1);
    }

    private static void dfs(int current) {
        visited[current] = true;
        System.out.println((char)(current + 64));

        for(Node temp = adjList[current]; temp != null; temp = temp.link) {
            if(!visited[temp.to]) dfs(temp.to);
        }
    }

    private static void bfs(int current) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current);
        visited[current] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println((char)(cur + 64));

            for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
                if(visited[temp.to]) continue;
                
                visited[temp.to] = true;
                queue.offer(temp.to);
            }
        }
    }
}