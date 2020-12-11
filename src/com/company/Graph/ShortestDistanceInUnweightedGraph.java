package com.company.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class ShortestDistanceInUnweightedGraph {
    // Find the shortest distance in an unweighted graph and find its length also .

    //I/P:  1 - 0   7   6                                   O/P: 0 3 7
    //      |   | / | / |                                        the length is : 2
    //      2   3 - 4 - 5
    // where 0 is source and 7 is the destination

    //We can do this in O(V+E) .  This algo will work even when negative cycles are present in the graph .
    //The approach would be to make two arrays pred, dist -> pred tells the immediate predecessor and dist
    // tells the distance from the source . Traverse graph through BFS marking distance of prev with +1 and
    // pred marked as u . Then just add it to the linked list for printing path traversing from dest to source
    // using pred array and also print length using dest array .

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i,int j) {

        adj.get(i).add(j);
        adj.get(j).add(i);
    }
    public static void main(String[] args) {

        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 0, dest = 7;

        findShortestDistance(adj, source, dest, v);
    }

    private static void findShortestDistance(ArrayList<ArrayList<Integer>> adj, int source, int dest, int v) {

        int[] pred = new int[v];
        int[] dist = new int[v];

        if(! BFS(adj, source, dest, v, pred, dist)) {
            System.out.println("source and destination are not connected");
        }

        LinkedList<Integer> path = new LinkedList<>();
        int crawl = dest;
        path.add(crawl);
        while(pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        System.out.println("Shortest path length is: " + dist[dest]);

        // Print path
        System.out.print("Path is :: ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int source, int dest, int v, int[] pred, int[] dist) {

        LinkedList<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        visited[source] = true;
        dist[source] = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (! visited[adj.get(u).get(i)]) {
                    visited[adj.get(u).get(i)] = true;

                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    if(adj.get(u).get(i) == dest) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
