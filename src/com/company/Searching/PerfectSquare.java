package com.company.Searching;

import java.util.Scanner;

public class PerfectSquare {

    public static void main(String[] args) {
        // I/P: x = 4               O/P: 2
        //if we cannot find the perfect square of 'x' just print the floor.

        Scanner sc  =new Scanner(System.in);
        int x = sc.nextInt();

        int result = findPerfectSquare(x);

        System.out.println(result);
    }

    private static int findPerfectSquare(int x) {

        int ans = 0;

        if(x == 0 || x == 1) {
            return -1;
        }
        int start = 1, end = x;



        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(mid * mid == x) {
                return mid;
            }
            else if(mid * mid < x) {
                start = mid + 1;
                ans = mid;
            }
            else
                end = mid - 1;
        }

        return ans;

    }
}
