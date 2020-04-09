package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Priority Queue를 이용한 Prim 알고리즘
 * 무향 graph만을 지원
 * queue에 node들을 저장하고 최소의 weight를 가지는 node를 선택하도록 한다.
 */

 public class Prim {
    final int INF = Integer.MAX_VALUE;
    int treeDistance = 0;
    int[][] nodes;
    boolean[] visited;
    ArrayList<Node>[] edges;
    PriorityQueue<Node> pq;

    Prim(int numOfNodes, int src, ArrayList<Node>[] edges) {
        nodes = new int[numOfNodes+1][2];
        for(int i = 1; i <= numOfNodes; i++) nodes[i][0] = INF;
        nodes[src][0] = 0;
        
        this.edges = new ArrayList[numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) {
            this.edges[i] = new ArrayList<>();
            for(Node node : edges[i]) this.edges[i].add(new Node(node.idx, node.distance));
        }
        
        pq = new PriorityQueue<>();
        pq.addAll(edges[src]);
        int cnt = 1;
        
        visited = new boolean[numOfNodes+1];
        visited[src] = true;
        while(cnt != numOfNodes) {
            Node current = pq.poll();
            if(visited[current.idx]) continue;
            visited[current.idx] = true;
            treeDistance += current.distance;
            pq.addAll(this.edges[current.idx]);
            cnt++;
        }

        System.out.println("entire tree distance: " + treeDistance);
    }
 }