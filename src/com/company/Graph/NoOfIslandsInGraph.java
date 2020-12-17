package com.company.Graph;

public class NoOfIslandsInGraph {
    // Given a 2d boolean matrix, count the number of island in the graph (An isand represents the no of 1s that are adjacent to it).

    //The approach would be to use modified DFS, instead of calling for each vertex in a graph we just can adjacent neighbours for each element that are 1 keeping track of visited node


    public static void main(String[] args) {

        int[][] arr = { { 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 1 },
            { 1, 0, 0, 1, 1 },
            { 0, 0, 0, 0, 0 },
            { 1, 0, 1, 0, 1 } };

        int count = 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == 1 && !visited[i][j]) {
                    drawTreeForComponent(arr, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println("The number of islands are : "+ count);
    }

    private static void drawTreeForComponent(int[][] arr, int i, int j, boolean[][] visited) {

        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] || arr[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        drawTreeForComponent(arr, i - 1, j, visited);   //for north
        drawTreeForComponent(arr, i + 1, j, visited);   //for south
        drawTreeForComponent(arr, i, j + 1, visited);   //for east
        drawTreeForComponent(arr, i, j - 1, visited);   //for west
    }
}
