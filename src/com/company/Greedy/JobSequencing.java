package com.company.Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    // Maximize the profit int two conditions : Only 1 Job can be done at a time and
    // every job have single time slot . Get profit only if we finish job within given deadline .

    //      Jobs    Deadline    Profit
    //I/P:  a       4           70                               //O/P: 100 + 70 = 170
    //      b       1           80
    //      c       1           30
    //      d       1           100

    //TC -> O(nlogn + d * n) , nlogn for sorting and d is the no of job to schedule and n is that we iterate over all jobs .
    //The approach would be to sort jobs according to the profit and process it
    // 1 by 1 ( for every job find the latest slot ) if no free slot is there skip it .


    static class Job {
        char id;
        int deadline, profit;

        Job() {}

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        private static void printMaximizeProfit(ArrayList<Job> arr, int t) {

            int n = arr.size();

            arr.sort((a, b) -> b.profit - a.profit);

            boolean[] emptySlots = new boolean[t];

            int maximizeProfit = 0;

            char[] job = new char[t];

            for (Job value : arr) {
                for (int j = Math.min(t - 1, value.deadline - 1); j >= 0; j--) {

                    if (!emptySlots[j]) {
                        emptySlots[j] = true;
                        job[j] = value.id;
                        maximizeProfit += value.profit;
                        break;
                    }
                }
            }

            for(char jb : job) {
                System.out.println(jb+" ");
            }
            System.out.println();

            System.out.println("Maximum Profit = "+maximizeProfit);
        }
    }

    public static void main(String[] args) {

        ArrayList<Job> arr = new ArrayList<>();

        arr.add(new Job('a', 4, 70));
        arr.add(new Job('b', 1, 80));
        arr.add(new Job('c', 1, 30));
        arr.add(new Job('d', 1, 100));

        Job.printMaximizeProfit(arr, 2);
    }
}
