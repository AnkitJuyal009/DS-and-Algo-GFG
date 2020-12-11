package com.company.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingDFS {
    // Given an unweighted, directed graph which is dependent .

    //    0   4                 O/P: 0 4 1 2 5 3 6 (can be in any order)
    //    |   |
    //    1   5
    //   / \ / \
    //  2   3   6

    //The approach is to use modified DFS . Starting from source we traverse every adjacent
    // vertex until the leaf node not comes up and then push them in stack when all nodes
    // are visited that are adjacent to the source starting from leaf node .

    static class Graph {
        private int V;
        private ArrayList<ArrayList<Integer>> adj;

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

        void topologicalSortUtil(int s, boolean[] visited, Stack<Integer> stack) {

            visited[s] = true;


            for (int i = 0; i < adj.get(s).size(); i++) {
                if(!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            stack.push(s);
        }

        void topologicalSort() {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                if(!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            while(!stack.empty()) {
                System.out.print(stack.pop()+" ");
            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 6);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }
}
