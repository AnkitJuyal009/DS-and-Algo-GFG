package com.company.Graph;

import java.util.*;

public class printAllNodesOnGraph {
    // Print all the nodes of the graph if source is given (source can be any node from the graph) .

    //I/P:     0                        O/P: 0 1 2 3 4 5 6
    //        / \
    //       1    2
    //      / \  / \
    //     3 - 4 5  6
    //   S = 0

    // Approach is to use BFS or DFS, traverse the whole graph and make visited array as it is undirected
    // graph so we ave to keep a check on the nodes that we go through .

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static void BFS(ArrayList<ArrayList<Integer>> adjL, int source) {

        System.out.println("BFS Traversal ->");

        LinkedList<Integer> queue = new LinkedList<>();
        int size = adjL.size();
        boolean[] visited = new boolean[size];
        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source +" ");

            for (int n : adjL.get(source)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    private static void DFS(ArrayList<ArrayList<Integer>> adjL, int source, boolean[] visited) {

        visited[source] = true;
        System.out.print(source +" ");

        for (int i = 0; i < adjL.size(); i++) {

            if(!visited[i]) {
                DFS(adjL, i, visited);
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 4, 6);

        BFS(adj, 0);

        System.out.println();
        System.out.println("DFS Traversal ->");

        DFS(adj, 0, visited);



    }

}
