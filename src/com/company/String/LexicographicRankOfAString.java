package com.company.String;

public class LexicographicRankOfAString {

    static final int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        // I/P: s = "STRING"                O/P:

        String s = "string";

        int result = findLexicographicRank(s);

        System.out.println(result);
    }

    private static int findLexicographicRank(String s) {

        int len = s.length();
        int fact = factorial(len);
        int rank = 1;
        int[] count = new int[NO_OF_CHARS];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 1; i < NO_OF_CHARS; i++) {
            count[i] += count[i - 1] ;
        }

        for (int i = 0; i < len; i++) {
            fact /= len - i;

            rank += count[s.charAt(i) - 1] * fact;

            updateCount(count, s.charAt(i));
        }

        return rank;
    }

    private static void updateCount(int[] count, char c) {

        for (char i = c; i < NO_OF_CHARS; i++) {
            --count[i];
        }
    }

    private static int factorial(int len) {
        if(len <= 1)
            return 1;
        else
            return len * factorial(len - 1);
    }
}
