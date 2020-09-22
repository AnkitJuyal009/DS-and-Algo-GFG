package com.company.Searching;

public class LeftMostIndexOfElement {

    public static void main(String[] args) {
        // Given a sorted array with repetitions, find leftmost index of an element
        //  I/P: arr[] : {2, 3, 3, 3, 3}            O/P: 1 (leftmost index of 3 is 1)
        // x : 3

        int[] arr = {2,3,3,3,3};
        int x = 4;

        int start = 0;
        int end = arr.length - 1;

        int result = findLeftMostIndex(arr, x, start, end);

        System.out.println(result);

    }

    private static int findLeftMostIndex(int[] arr, int x, int start, int end) {

             while(start <= end) {

                 int mid = (start + ((end - start) / 2));

                 if (arr[mid] == x && (mid == 0 || arr[mid - 1] != x)) {
                     return mid;
                 } else if (arr[mid] >= x) {
                     end = mid - 1;
                 } else if (arr[mid] < x) {
                     start = mid + 1;
                 }
             }

             return -1;

    }
}
