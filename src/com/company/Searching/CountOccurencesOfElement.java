package com.company.Searching;

public class CountOccurencesOfElement {

    public static void main(String[] args) {
        // find no. of occurences of a element in array
        // I/P: arr[] : {2, 3, 3, 3, 3}             O/P: 4 ( no of 3s in array is 4 )
        // x : 3
        // SOLUTION : So to find the occurences of a number we just find the leftmostIndex of 'x'
        // and also the rightmostIndex and then subtract them.

        int[] arr = {2, 3, 3, 3, 3};
        int x = 2;
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        int leftIndex = findLeftMostIndex(arr, x, start, end);

        int rightIndex = findRightMostIndex(arr, x, start, end, n);

        System.out.println(rightIndex - leftIndex + 1);
    }

    private static int findRightMostIndex(int[] arr, int x, int start, int end, int n) {

        while(start <= end) {
            int mid = (start + ((end - start) / 2));

            if(arr[mid] == x && (mid == n -1 || arr[mid + 1] != x)) {
                return mid;
            }
            else if(arr[mid] > x) {
                end = mid -1;
            }
            else if(arr[mid] <= x) {
                start = mid + 1;
            }
        }

        return  -1;

    }

    private static int findLeftMostIndex(int[] arr, int x, int start, int end) {

        while(start <= end) {
            int mid = (start + ((end - start) / 2));

            if(arr[mid] == x && (mid ==0 || arr[mid - 1] != x)) {
                return mid;
            }
            else if(arr[mid] >= x) {
                end = mid -1;
            }
            else if(arr[mid] < x) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
