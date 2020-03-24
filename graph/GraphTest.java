package graph;

import java.util.ArrayList;

class Node implements Comparable<Node> {
    int idx, distnace;

    Node(int idx, int distance) {
        this.idx = idx;
        this.distnace = distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distnace - o.distnace;
    }
}

public class GraphTest {
    /**
     *      1   2   3   4   5
     * 1    0   0   6   3   0
     * 2    3   0   0   0   0
     * 3    0   0   0   2   0
     * 4    0   1   1   0   0
     * 5    0   4   0   2   0
     */
    public static void main(String[] args) {
        int numOfNodes = 5, src = 5;
        ArrayList<Node>[] edges = new ArrayList[numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) edges[i] = new ArrayList<>();

        edges[1].add(new Node(3, 6));
        edges[1].add(new Node(4, 3));
        edges[2].add(new Node(1, 3));
        edges[3].add(new Node(4, 2));
        edges[4].add(new Node(2, 1));
        edges[4].add(new Node(3, 1));
        edges[5].add(new Node(2, 4));
        edges[5].add(new Node(4, 2));

        // dijkstra
        Dijkstra dijkstra = new Dijkstra(numOfNodes, src, edges);
    }
}