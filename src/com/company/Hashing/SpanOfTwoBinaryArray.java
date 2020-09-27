package com.company.Hashing;

import java.util.HashMap;

public class SpanOfTwoBinaryArray {

    public static void main(String[] args) {
        //The problem is to find the longest span of two binary arrays with same sum
        //I/P: arr1[] = {0, 1, 0, 0, 0, 0};             O/P: 4   //(index -> 1 to 4)
        //       arr2[] = {1, 0, 1, 0, 0, 1};

        int[] arr1 = {0, 1, 0, 0, 0, 0};
        int[] arr2 = {1, 0, 1, 0, 0, 1};

        int n = arr1.length;

        int result = findLongestSpan(arr1, arr2, n);

        System.out.println(result);
    }

    private static int findLongestSpan(int[] arr1, int[] arr2, int n) {

        int[] arr = new int[n];
        int sum = 0 , max_len = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i] - arr2[i];
        }

            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int j = 0; j < n; j++) {
                sum += arr[j];

                if(sum == 0) {
                    max_len = j + 1;
                }

                if(hm.containsKey(sum + n)) {
                    max_len = Math.max(max_len , j - hm.get(sum + n));
                }
                else
                    hm.put(sum + n, j);
            }

            return max_len;
    }
}
