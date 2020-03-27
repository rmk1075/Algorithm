package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * priorityQueue를 사용한 dijkstra 알고리즘
 * 무향, 유향 상관없이 모든 graph 지원
 */

public class Dijkstra {
    int INF = Integer.MAX_VALUE;
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
}