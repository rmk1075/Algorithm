package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays.sort와 Comparator를 이용한 Kruskal
 * union-find를 이용
 */

public class Kruskal {
    static int parent[], edges[][];

    Kruskal(int numOfNodes, ArrayList<Node>[] inputEdges) {
        int numOfEdges = 0;
        for(int i = 1; i < numOfNodes; i++) numOfEdges += inputEdges[i].size();
        edges = new int[numOfEdges][3];
        int idx = 0;
        for(int i = 1; i < numOfNodes; i++) {
            for(int j = 0; j < inputEdges[i].size(); j++) {
                edges[idx][0] = i;
                edges[idx][1] = inputEdges[i].get(j).idx;
                edges[idx++][2] = inputEdges[i].get(j).distance;
            }
        }

        Arrays.sort(edges, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[2] - o2[2];
           } 
        });

        parent = new int[numOfNodes+1];
        for(int i = 1; i <= numOfNodes; i++) parent[i] = i;

        int ans = 0, cnt = 0;
        for(int i = 0; i < numOfEdges; i++) {
            if(cnt == numOfNodes-1) break;

            int a = find(edges[i][0]), b = find(edges[i][1]);
            if(a == b) continue;
            parent[b] = a;
            ans += edges[i][2];
            System.out.println(edges[i][0] + " " +edges[i][1]);
            cnt++;
        }
        System.out.println("distance of MST: " + ans);
    }

    public static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
}