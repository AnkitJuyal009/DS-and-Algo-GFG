package com.company.Heap;

import java.util.PriorityQueue;

public class SortArray {
    //Sort an array that is almost sorted as in its given a 'k'
    // that is the deistance that every element is within this k
    // distance of sorted position .

    //I/P: arr[]: {9,8,7,18,19,17}                              O/P: {7,8,9,17,18,19}
    //      k = 2

    //SOLUTION: We add k elements in min heap and while traversing remaining elements
    // we remove root from heap and add it to array and meanwhile add remaining elements
    // to heap and continuing the process to make array sorted .

    public static void main(String[] args) {

        int[] arr = {9,8,7,18,19,17};
        int k = 2;
        int n = arr.length;

        sortArray(arr,n,k);
    }

    private static void sortArray(int[] arr, int n, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int oi = 0;

        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k+1; i < n; i++) {
            arr[oi] = pq.remove();
            oi++;
            pq.add(arr[i]);
        }

        while(!pq.isEmpty()) {
            arr[oi] = pq.remove();
            oi++;
        }

        for (Integer i : arr) {
            System.out.print(i+" ");
        }
    }
}
