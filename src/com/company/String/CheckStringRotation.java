package com.company.String;

public class CheckStringRotation {

    public static void main(String[] args) {
        // I/P: s = "abcd"              O/P: true
        //      s1 = "cdab"

        String s = "abcd";
        String s1 = "cdab";

        Boolean result = checkRotation(s, s1);

        System.out.println(result);
    }

    private static Boolean checkRotation(String s, String s1) {

        if(s.length() != s1.length()) {
            return false;
        }

        s = s.concat(s);

        return s.contains(s1);

    }
}
