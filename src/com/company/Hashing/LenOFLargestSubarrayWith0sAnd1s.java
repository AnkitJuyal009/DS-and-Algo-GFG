package com.company.Hashing;

import java.util.HashMap;

public class LenOFLargestSubarrayWith0sAnd1s {

    public static void main(String[] args) {
        //I/P: arr[] : {0, 1, 1, 0, 1, 1, 0}            O/P: 0,3    //->(0,1,1,0)
        // This one is bit tricky

        int[] arr = { 1, 0, 0, 1, 0, 1, 1 };
        int n = arr.length;

        findLongestSubarray(arr, n);
    }

    private static void findLongestSubarray(int[] arr, int n) {

        int max_len = 0 , sum = 0 , end_index = -1 , start_index = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] == 0 ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if(sum == 0) {
                max_len = i + 1;
                end_index = i;
            }

            if(hm.containsKey(sum + n)) {
                if (max_len < i - hm.get(sum + n)) {
                    max_len = i - hm.get(sum + n);
                    end_index = i;
                }
            }
            else
                hm.put(sum + n, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = end_index - max_len + 1;
        System.out.println(end + " to " + end_index);
    }
}
