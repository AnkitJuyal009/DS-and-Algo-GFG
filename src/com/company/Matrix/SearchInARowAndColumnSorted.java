package com.company.Matrix;

public class SearchInARowAndColumnSorted {

    public static void main(String[] args) {
        //  I/P: {{ {10, 20, 30, 40},               O/P: (3,2)
        //          {15, 25, 35, 45},
        //          {27, 29, 37, 48},
        //          {32, 33, 39, 50}};
        //       }
        //       x = 39;
        //SOLUTION : In this question, we just iterate over elements in the matrix and if the element is
        //           greater than x then column gets incremented and if element is smaller than x then
        //           row gets incremented.

        int[][] mat = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 50},
                      };
        int x = 39;

        int row = 0;
        int column = mat.length - 1;

        findElementInRowColumnSortedMatrix(mat, row, column, x);
    }

    private static void findElementInRowColumnSortedMatrix(int[][] mat, int row, int column, int x) {

        while(row < mat.length && column >= 0) {
            if(mat[row][column] > x) {
                column--;
            } else if(mat[row][column] < x) {
                row++;
            } else {
                System.out.println("Found at ( "+row+" , "+column+" )"); // if it comes to this statement then we got our answer!!
                return;
            }
        }
        System.out.println("Not Found");
    }
}
