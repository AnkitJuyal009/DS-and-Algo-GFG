package com.company.Matrix;

public class RotateMatrix {

    public static void main(String[] args) {
        //                                  (after rotating 90-degree counter clockwise)
        //  I/P: {{1, 2, 3},                  O/P: {{3, 6, 9},
        //        {4, 5, 6},                        {2, 5, 8},
        //        {7, 8, 9},                        {1, 4, 7},
        //       }                               }
        // SOLUTION : first we transpose the matrix and then we reverse each column of the matrix

        int[][] mat = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9},
                      };

        transposeMatrix(mat);

        findRotatedMatrix(mat);

    }

    private static void transposeMatrix(int[][] mat) {

        int temp;

        for (int i = 0; i < mat.length; i++) {
            for (int j = i+1; j < mat[0].length; j++) {

                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

            }
        }
    }

    private static void findRotatedMatrix(int[][] mat) {
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0, k = mat[0].length - 1; j < k; j++, k--) {
                int temp = mat[j][i];
                mat[j][i] = mat[k][i];
                mat[k][i] = temp;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                System.out.print(mat[i][j]+",");
            }

            System.out.println();
        }
    }
}
