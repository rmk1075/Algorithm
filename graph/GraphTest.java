package graph;

import java.util.ArrayList;

class Node implements Comparable<Node> {
    int idx, distance;

    Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
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
     * 
     *      1   2   3   4   5
     * 1    0   3   8   0   -4
     * 2    0   0   0   1   7
     * 3    0   4   0   0   0
     * 4    2   0   -5  0   0
     * 5    0   0   0   6   0
     */
    public static void main(String[] args) {
        int numOfNodes = 5;
        ArrayList<Node>[] edges = new ArrayList[numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) edges[i] = new ArrayList<>();

        edges[1].add(new Node(2, 3));
        edges[1].add(new Node(3, 8));
        edges[1].add(new Node(5, -4));
        edges[2].add(new Node(4, 1));
        edges[2].add(new Node(5, 7));
        edges[3].add(new Node(2, 4));
        edges[4].add(new Node(1, 2));
        edges[4].add(new Node(3, -5));
        edges[5].add(new Node(4, 6));

        // floyd-warshall
        System.out.println("floyd-warshall");
        FloydWarshall floydWarshall = new FloydWarshall(5, edges);
        System.out.println();

        numOfNodes = 6;
        edges = new ArrayList[numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) edges[i] = new ArrayList<>();

        edges[1].add(new Node(2, 2));
        edges[1].add(new Node(3, 2));
        edges[1].add(new Node(4, 1));
        edges[2].add(new Node(1, 2));
        edges[2].add(new Node(3, 3));
        edges[2].add(new Node(4, 2));
        edges[3].add(new Node(1, 2));
        edges[3].add(new Node(2, 3));
        edges[3].add(new Node(4, 3));
        edges[3].add(new Node(5, 1));
        edges[3].add(new Node(6, 5));
        edges[4].add(new Node(1, 1));
        edges[4].add(new Node(2, 2));
        edges[4].add(new Node(3, 3));
        edges[4].add(new Node(5, 1));
        edges[5].add(new Node(3, 1));
        edges[5].add(new Node(4, 1));
        edges[5].add(new Node(6, 2));
        edges[6].add(new Node(3, 5));
        edges[6].add(new Node(5, 2));

        // dijkstra
        int src = 1;
        System.out.println("dijkstra");
        Dijkstra dijkstra = new Dijkstra(numOfNodes, src, edges);
        System.out.println();

        // prim
        System.out.println("prim");
        Prim prim = new Prim(numOfNodes, src, edges);
        System.out.println();

        // kruskal
        System.out.println("kruskal");
        Kruskal kruskal = new Kruskal(numOfNodes, edges);
        System.out.println();
    }
}