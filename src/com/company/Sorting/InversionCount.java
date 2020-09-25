package com.company.Sorting;

import java.util.Arrays;

public class InversionCount {

    public static void main(String[] args) {
        //I/P: arr[] : {1, 20, 6, 4, 5}                                 O/P: 5
        //Inversion count for array means that how far (or close) the array is from being sorted

        int[] arr = {1, 20, 6, 4, 5};

        System.out.println(MergeSortAndCount(arr, 0, arr.length - 1));
    }

    private static int MergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;

        if(l < r) {
            int mid = l + (r - l) / 2;

            count += MergeSortAndCount(arr,0,mid);
            count += MergeSortAndCount(arr,mid + 1, r);

            count += MergeAndCount(arr, l, mid, r);
        }
        return count;
    }

    private static int MergeAndCount(int[] arr, int l, int mid, int r) {

        int[] left = Arrays.copyOfRange(arr, l, mid + 1);

        int[] right = Arrays.copyOfRange(arr, mid + 1, r + 1);

        int i = 0, j = 0, k = l , swap = 0;

        while(i < left.length && j < right.length) {
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swap += (mid + 1) - (l + i);
            }
        }

        while(i < left.length) {
            arr[k++] = left[i++];
        }

        while(j < right.length) {
            arr[k++] = right[j++];
        }

        return swap;
    }
}
