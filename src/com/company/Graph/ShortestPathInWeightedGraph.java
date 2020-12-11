package com.company.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class ShortestPathInWeightedGraph {
    // Find the shortest path in Weighted graph where weights are 1 and 2 only .

    // The approach would be to modify the graph, The vertices which have weight 2 we can split it up using immediate vertex and add weight 1-1 each .

    static class Graph {
        int V;
        Vector[] adj;

        static int level;

        Graph(int V) {
            this.V = V;
            this.adj = new Vector[2*V];

            for (int i = 0; i < 2 * V; i++) {
                this.adj[i] = new Vector();
            }
        }

        public void addEdge(int v, int w, int weight) {
            if(weight == 2) {
                adj[v].add(v + this.V);
                adj[v + this.V].add(w);
            } else {
                adj[v].add(w);
            }
        }

        public int findShortestPath(int src, int dest) {
            boolean[] visited = new boolean[2 * this.V];
            int[] parent = new int[2 * this.V];

            for (int i = 0; i < 2 * V; i++) {
                visited[i] = false;
                parent[i] = -1;
            }

            Queue<Integer> queue = new LinkedList<>();

            visited[src] = true;
            queue.add(src);

            while(!queue.isEmpty()) {
                int u = queue.peek();

                if(u == dest) {
                    return printShortestPath(parent, u, dest);
                }
                queue.poll();

                for(int i = 0; i < this.adj.length; i++) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                        parent[i] = u;
                    }
                }
            }

            return 0;
        }

        private int printShortestPath(int[] parent, int u, int dest) {

            level = 0;

            if(parent[u] == -1) {
                System.out.printf("Shortest Path between"+
                        "%d and %d is %s ", u, dest, u);
                return level;
            }

            printShortestPath(parent, parent[u], dest);
            level++;

            if(u < this.V) {
                System.out.printf("%d", u);
            }
            return level;
        }
    }

    public static void main(String[] args)
    {

        // Create a graph given in the above diagram
        int V = 4;
        Graph g = new Graph(V);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 0, 1);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 3, 2);

        int src = 0, dest = 3;
        System.out.printf("\nShortest Distance between" +
                        " %d and %d is %d\n", src,
                dest, g.findShortestPath(src, dest));
    }
}
