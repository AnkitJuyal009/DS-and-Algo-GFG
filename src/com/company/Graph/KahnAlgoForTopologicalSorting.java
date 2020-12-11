package com.company.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class KahnAlgoForTopologicalSorting {
    // Given a DAG (directed acyclic graph) topological sort the graph .

    // The approach would be to first compute the in-degrees of every vertex
    // of graph and initialize visited nodes as 0 and then pick all vertices
    // as in-degree = 0 and enqueue them . Remove vertex from queue and increment
    // count of visited nodes by 1, Decrease in-degree by 1 for all its neighbouring
    // nodes, if in-degree of neighbouring nodes is reduced to 0, then add to queue .

    static class Graph {
        private int V;
        private final ArrayList<ArrayList<Integer>> adj;

        Graph(int v) {
            V = v;
            adj = new ArrayList<ArrayList<Integer>>(v);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        public void topologicalSort() {
            int[] inDegree = new int[V];

            for (int i = 0; i < V; i++) {
                ArrayList<Integer> temp = adj.get(i);

                for(int node : temp) {
                    inDegree[node]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < V; i++) {
                if(inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            int count = 0;

            Vector<Integer> order = new Vector<>();

            while(!queue.isEmpty()) {
                int u = queue.poll();
                order.add(u);

                for(int node : adj.get(u)) {
                    if(--inDegree[node] == 0) {
                        queue.add(node);
                    }
                }
                count++;
            }

            if(count != V) {
                System.out.println("There is a cycle in Graph");
                return;
            }

            for(int i : order) {
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println(
                "Following is a Topological Sort");
        g.topologicalSort();
    }
}
