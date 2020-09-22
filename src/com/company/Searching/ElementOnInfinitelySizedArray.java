package com.company.Searching;

public class ElementOnInfinitelySizedArray {
    // find element x on infinitely large array where array conatins 10^5 values
    // I/P: arr[] : {2, 6, 7, 8, 10, 14, 21, .....}             O/P: 4
    // x : 10
    // We want to do it in O(log n)
    //SOLUTION : In this one, we cannot do binary search as the end is infinte , so we just iterate
    // over elements with 2^i where i is the number starting from 1 unil we find the element greater
    // than 'x' and then we do binary search.

    public static void main(String[] args) {

        int[] arr = {2, 6, 7, 8, 10, 14, 21, 43, 65}; // assuming to be infinitely sized array
        int x = 10;

        int result = findElementInInfinitelySizedArray(arr, x);

        System.out.println(result);

    }



    private static int findElementInInfinitelySizedArray(int[] arr, int x) {

        if(arr[0] == x) {
            return 0;
        }
        int i = 1;

        while(arr[i] > x) {
            i *= 2;
        }
        if(arr[i] == x) {
            return i;
        }
        else {
            return binarySearch(arr, x);
        }
    }

    private static int binarySearch(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + ((end - start) / 2));

            if(arr[mid] == x) {
                return mid;
            }
            else if(arr[mid] > x) {
                end = mid - 1;
            }
            else if(arr[mid] < x) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
