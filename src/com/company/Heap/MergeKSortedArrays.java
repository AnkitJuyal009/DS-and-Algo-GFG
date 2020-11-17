package com.company.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Merge K sorted arrays that can have equal size or different .

//I/P: mat[][] = { {5,10}                       O/P: {1,2,3,5,10,15,25,30,40}
//                 {2,3,15}
//                 {1,25,30,40}
//               }

//Approach would be to make a min heap of 1st column of every array and takes the roort and add those elements of array which root is taken out .

class ArrayContainer implements Comparable<ArrayContainer> {
    int[] arr; int index;

    public ArrayContainer(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public int compareTo(ArrayContainer o) {
        return this.arr[this.index] - o.arr[o.index];
    }
}

public class MergeKSortedArrays {

    public static void main(String[] args) {

        int[][] mat = {  {5,10},
                         {2,3,15},
                         {1,25,30,40}
                      };

        int[] result = mergeKsortedArray(mat);

        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeKsortedArray(int[][] mat) {

        PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
        int total = 0;

        for (int i = 0; i < mat.length; i++) {

            pq.add(new ArrayContainer(mat[i], 0));
            total += mat[i].length;
        }

        int m = 0;
        int[] result = new int[total];

        while(!pq.isEmpty()) {
            ArrayContainer ac = pq.poll();
            result[m++] = ac.arr[ac.index];

            if(ac.index < ac.arr.length - 1) {
                pq.add(new ArrayContainer(ac.arr, ac.index + 1));
            }
        }

        return result;


    }

}
