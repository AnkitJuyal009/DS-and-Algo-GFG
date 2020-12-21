package com.company.Greedy;

import java.util.Scanner;

public class EgyptianFraction {
    //Every positive fraction can be represented as sum of unique unit fractions.
    // A fraction is unit fraction if numerator is 1 and denominator is a positive
    // integer, for example 1/3 is a unit fraction. Such a representation is called
    // Egyptian Fraction as it was used by ancient Egyptians.

    //I/P: 6/14                     O/P: 1/3 + 1/11 + 1/231

    //The approach would be to find the ceiling of 14/6 i.e 3 so the first unit fraction would be 1/3
    //And then recur same by subtracting the original from the unit fraction tha we obtain.
    //i.e 6/14 - 1/3 = 4/42 and the process same as before .

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nr = sc.nextInt();
        int dr = sc.nextInt();

        findEgyptianFraction(nr, dr);
    }

    private static void findEgyptianFraction(int nr, int dr) {

       if(nr == 0 || dr == 0) {
           return;
       }

       if(dr % nr == 0) {
           System.out.print("1/"+dr/nr);
           return;
       }

        if (nr % dr == 0) {
            System.out.print(nr / dr);
            return;
        }

        if (nr > dr) {
            System.out.print(nr / dr + " + ");
            findEgyptianFraction(nr % dr, dr);
            return;
        }

        int n = dr/nr + 1;
        System.out.print("1/"+ n +" + ");

        findEgyptianFraction(nr *n - dr, dr * n);



    }
}
