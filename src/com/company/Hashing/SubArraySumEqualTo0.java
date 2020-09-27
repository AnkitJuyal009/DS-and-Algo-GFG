package com.company.Hashing;

import java.util.HashSet;

public class SubArraySumEqualTo0 {

    public static void main(String[] args) {
        //I/P: arr[] : {5, 6, -4, -2, 8, 10}            O/P: true (6,-4,-2) their sum equal to 0
        // In this question we first compute Prefix sum and chcek if values are duplicated in the array or not

        int[] arr = {5, 6, -4, -2, 8, 0};

        HashSet<Integer> hs = new HashSet<>();
        int pre_sum = 0;

        for (int j : arr) {
            pre_sum += j;

            if (j == 0 || pre_sum == 0 || hs.contains(pre_sum)) {
                System.out.println("true");
                return;
            }
            hs.add(pre_sum);

        }

        System.out.println("false");
    }
}
