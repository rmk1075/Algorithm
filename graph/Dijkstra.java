package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * priorityQueue를 사용한 dijkstra 알고리즘
 */

public class Dijkstra {
    int[] nodes;
    ArrayList<Node>[] edges;
    PriorityQueue<Node> pq = new PriorityQueue<>();

    Dijkstra(int numOfNodes, int src, ArrayList<Node>[] edges) {
        nodes = new int[numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) nodes[i] = Integer.MAX_VALUE;
        nodes[src] = 0;

        this.edges = edges;

        pq.offer(new Node(src, 0));
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            for(Node edge : edges[curNode.idx]) {
                if(nodes[edge.idx] <= curNode.distnace + edge.distnace) continue;

                nodes[edge.idx] = curNode.distnace + edge.distnace;
                pq.offer(new Node(edge.idx, nodes[edge.idx]));
            }
        }

        for(int i = 1; i <= numOfNodes; i++) {
            System.out.println(i + ": " + ((nodes[i] == Integer.MAX_VALUE) ? "INF" : nodes[i]));
        }
    }
}