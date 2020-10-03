package com.company.String;

public class SearchPatternInString {

    public static void main(String[] args) {
        // I/P: s = "ABCABDD"            O/P: 2
        //      pat = "CAB"
        // I/P: s = "AAAAAA"             O/P: 0 1 2
        //      pat = "AAA"
        // for above input is repeating so the output just prints for every starting index of pattern string.
        // EXAMPLE: for 0 we can take the first three AAA's so starting index is 0
        // for 1 we can take the AAA's from index 1 and
        // for 2 same as 1 taking from index 2

        //We can use Naive String algo here that is we make count array of pattern and string and
        // check frequency if found we return index but if not we just move to the next index for further search.
        // But this algo doesn't work well if the string is redundant (EXAMPLE: "AAAAAAA")
        //TC -> (O(n-m)*n)
        //we can do it in O(n) time with preprocessing pattern string using KMP algo.

        String s = "AABAACAADAABAABA";
        String pat = "AABA";

        searchPattern(s, pat);
    }

    private static void searchPattern(String s, String pat) {

        int lenPat = pat.length();
        int lenS = s.length();
        int j = 0; // index of pat
        int[] lps = new int[lenPat];
        precomputePattern(pat, lenPat, lps); // precomputation of pattern

        int i = 0; // index of s

        while(i < lenS) {
            if(pat.charAt(j) == s.charAt(i)) {  //match found increment i and j
                j++;
                i++;
            }
            if(j == lenPat) {
                System.out.println("Found pattern at "+(i - j));
                j = lps[j - 1];
            }
            else if(i < lenS && pat.charAt(j) != s.charAt(i)) {
                if(j != 0) {
                    j = lps[ j - 1];
                }
                else {
                    i++;
                }
            }
        }
    }

    private static void precomputePattern(String pat, int lenPat, int[] lps) {

        int i = 1;
        int len = 0;
        lps[0] = 0;

        while(i < lenPat) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
