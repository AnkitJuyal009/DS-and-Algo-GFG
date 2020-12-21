package com.company.DisjointSet;

import com.company.Greedy.JobSequencing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencingUsingDisjointSet {
    // Maximize the profit int two conditions : Only 1 Job can be done at a time and
    // every job have single time slot . Get profit only if we finish job within given deadline .

    //      Jobs    Deadline    Profit
    //I/P:  a       4           70                               O/P: d a
    //      b       1           80                                    100 + 70 = 170
    //      c       1           30
    //      d       1           100

    ////TC -> O(nlogn + d + n) , nlogn for sorting and d is the no of job to schedule and n is that we iterate over all jobs .   (Optimized than Greedy)

    //Approach would be same as Greedy one with one thing that we will use disjoint set to allot free time for job scheduling .

    static class DisjointSet {
        int[] parent;

        DisjointSet(int n) {
            parent = new int[n + 1];

            //Every node is a parent itself. initially
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        private int find(int s) {
            if(s == parent[s])
                return s;
            return parent[s] = find(parent[s]);
        }

        private void merge(int u, int v) {
            parent[v] = u;
        }

    }

    static class Job implements Comparator<Job> {
        char id;
        int deadline, profit;

        Job() {}

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        public static void findMaximizeProfit(ArrayList<Job> arr) {

            arr.sort(new Job ());
            int maxProfit = 0;

            int maximumDeadline = findMaximumDeadline(arr);
            DisjointSet dsu = new DisjointSet(maximumDeadline);

            for(Job temp : arr) {

                int availableSlot = dsu.find(temp.deadline);

                if(availableSlot > 0) {

                    dsu.merge(dsu.find(availableSlot - 1), availableSlot);
                    maxProfit += temp.profit;
                    System.out.println(temp.id+" ");
                }
            }
            System.out.println();
            System.out.println("Maximum profit is = "+maxProfit);
        }

        private static int findMaximumDeadline(ArrayList<Job> arr) {

            int max = Integer.MIN_VALUE;

            for (Job value : arr) {
                max = Math.max(max, value.deadline);
            }

            return max;
        }

        @Override
        public int compare(Job o1, Job o2) {
            return o1.profit > o2.profit ? -1 : 1;
        }
    }

    public static void main(String[] args) {

        ArrayList<Job> arr = new ArrayList<>();

        arr.add(new Job('a', 4, 70));
        arr.add(new Job('b', 1, 80));
        arr.add(new Job('c', 1, 30));
        arr.add(new Job('d', 1, 100));

        Job.findMaximizeProfit(arr);

    }


}
