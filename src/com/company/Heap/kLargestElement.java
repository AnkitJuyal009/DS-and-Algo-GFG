package com.company.Heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class kLargestElement {
    //Given an unsorted array find the kth largest element

    //I/P: arr[]: {5,10,20,11,8}                O/P: 11 20
    //k = 2

    //Approach would be to build a max heap and extract two maximum that takes O(n + klogn) time
    //Better approach would be to build a in heap of k elements and then traverse from k+1 elements
    // and compare it with root if greater than the root then insert it and at last print k elements

    public static void main(String[] args) {

        int[] arr = {5, 10, 20, 11, 8};
        int k = 2;
        int n = arr.length;

        findKlargestelement(arr,n,k);
    }

    private static void findKlargestelement(int[] arr, int n, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            if(arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);

            }
        }

        for (Integer integer : pq) {
            System.out.print(integer + " ");
        }
    }
}
