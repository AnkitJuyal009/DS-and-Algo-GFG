package com.company.Matrix;

public class TransposeOfMatrix {

    public static void main(String[] args) {
        // so transposing of a matrix means that every row becomes column of the resulting matrix.
        //I/P: {{1, 2, 3},             O/P: {{1, 7, 11},
        //      {7, 8, 9},                   {2, 8, 12},
        //      {11, 12, 13},                {3, 9, 13},
        //     }                          }
        int[][] mat = {{1, 2, 3},
                       {7, 8, 9},
                       {11, 12, 13},
                      };

        findTransposeOfMatrix(mat);

    }

    private static void findTransposeOfMatrix(int[][] mat) {

        int temp;

        for (int i = 0; i < mat.length; i++) {
            for (int j = i+1; j < mat[0].length; j++) {

                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

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
