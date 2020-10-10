package com.company.String;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        //I/P: str[] = {"flower", "flow", "flight"}             //O/P: fl
        
        String[] strs = {"flower", "flow", "flight"};
        int len = strs.length;
        
        findLongestCommonPrefix(strs, len);
    }

    private static void findLongestCommonPrefix(String[] strs, int len) {

        String prefix = strs[0];
        for (int i = 1; i < len; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    System.out.println("");
            }
        System.out.println(prefix);
    }
}
