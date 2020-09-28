package com.company.String;

import java.util.Arrays;

public class CheckAnagram {

    static final int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        // I/P: s = "gfg"               O/P: true
        //      s1 = "ggf
        //To check anagram of two strings, their characte rfrequency should be equal
        // as in this case first stru=ing have 2 'g' and 1 'f' and second string have also 2 'g' and 1 'f'

        String s = "gfg";
        String s1 = "ggf";

        Boolean result = findAnagram(s, s1);

        System.out.println(result);
    }

    private static Boolean findAnagram(String s, String s1) {

        int[] count = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        if(s.length() != s1.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
        }

        for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i)]--;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;

    }
}
