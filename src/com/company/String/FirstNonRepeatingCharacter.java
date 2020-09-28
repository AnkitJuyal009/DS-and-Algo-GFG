package com.company.String;

import java.util.Arrays;

class FirstNonRepeatingCharacter {

     public static void main(String[] args) {
         // I/P: s1 = "geeksforgeeks"             // O/P: 'f'
         //first non repeating character in 's' is 'f'.

         String s = "geeksforgeeks";

         int index = findNonRepeatingCharacter(s);

         System.out.println(s.charAt(index));
     }

     private static int findNonRepeatingCharacter(String s) {

         int[] index = new int[256];
         Arrays.fill(index, -1);

         for (int i = 0; i < s.length(); i++) {
             if (index[s.charAt(i)] == -1) {
                 index[s.charAt(i)] = i;
             } else
                 index[s.charAt(i)] = -1;
         }
         for (int i = 0; i < index.length; i++) {
             if (index[s.charAt(i)] > -1) {
                 return i;
             }
         }
         return 0;
     }
 }
