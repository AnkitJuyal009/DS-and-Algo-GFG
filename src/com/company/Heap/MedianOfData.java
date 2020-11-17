package com.company.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfData {
    // We have to find the median of the stream of data .
    //I/P: arr[]: {5, 20, 30, 15, 18, 6, 3----                O/P: 5, 12.5, 20, 17.5, 18 ---

    //The approach would be to use Self BST
    //Another approach would be to use Heaps -> make a max heap and a min heap that contains
    // elements of lower half and one contains elements of higher half respectively . If size
    // of any heap is pqMin than the other then we make the top element median of respective heap
    // and if they both are equal then we take an average of the top elements of bothe the heaps .

    public static void main(String[] args) {

        int[] arr = {5, 20, 30, 15, 18, 6, 3};
        int n = arr.length;

        findMedianOfStream(arr, n);



    }

    private static void findMedianOfStream(int[] arr, int n) {

        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        double med = arr[0];
        pqMax.add(arr[0]);
        System.out.println(med);

        for (int i = 1; i < n; i++) {

            int x = arr[i];

            if(pqMax.size() > pqMin.size()) {
                if(x > med) {
                    pqMin.add(pqMax.remove());
                    pqMax.add(x);
                }
                else {
                    pqMin.add(x);
                }
                med = (double) (pqMax.peek() + pqMin.peek()) / 2;
            }

            else if(pqMax.size() == pqMin.size()) {
                if(x < med) {
                    pqMax.add(x);
                    med = (double) pqMax.peek();
                }
                else
                {
                    pqMin.add(x);
                    med = (double) pqMin.peek();
                }
            }

            // case3(right side heap has more elements)  
            else
            {
                if(x > med)
                {
                    pqMax.add(pqMin.remove());
                    pqMin.add(x);
                }
                else
                    pqMax.add(x);
                med = (double)(pqMax.peek() + pqMin.peek())/2;

            }
            System.out.println(med);
        }
    }
}
