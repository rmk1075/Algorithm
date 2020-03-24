package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2d array를 사용한 floyd-warshall algorithms
 * - 모든 경로에 대한 비용
 * min(A -> C) = min(A -> B) + min(B -> C)
 */

public class FloydWarshall {
    final int INF = Integer.MAX_VALUE;
    int[][] distances, edges;

    FloydWarshall(int numOfNodes, ArrayList<Node>[] edges) {
        distances = new int[numOfNodes+1][numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) {
            for(int j = 1; j <= numOfNodes; j++) {
                if(i == j) continue;
                distances[i][j] = INF;
            }
        }

        // list to array
        this.edges = new int[numOfNodes+1][numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) Arrays.fill(this.edges[i], INF);
        for(int i = 1; i <= numOfNodes; i++) {
            for(Node node : edges[i]) {
                int j = node.idx;
                this.edges[i][j] = distances[i][j] = Math.min(distances[i][j], node.distnace);
            }
        }

        for(int i = 1; i <= numOfNodes; i++) {
            for(int j = 1; j <= numOfNodes; j++) {
                if(i == j || distances[i][j] == INF) continue;

                for(int k = 1; k <= numOfNodes; k++) {                    
                    if(distances[k][i] == INF || distances[k][j] <= distances[k][i] + distances[i][j]) continue;
                    distances[k][j] = distances[k][i] + distances[i][j];
                }
            }
        }

        for(int i = 1; i <= numOfNodes; i++) {
            for(int j = 1; j <= numOfNodes; j++) {
                System.out.print((distances[i][j]  == INF ? "NIL" : distances[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}