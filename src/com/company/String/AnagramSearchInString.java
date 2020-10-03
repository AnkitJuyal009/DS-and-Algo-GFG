package com.company.String;

public class AnagramSearchInString {

    static final int MAX = 256;
    
    public static void main(String[] args) {
        //I/P: s = "geeksforgeeks"          O/P: true
        //     anagram = "rof"
        //Anagram Search maens the frequency of characters in 'anagram'
        // should contain in s string with equal frequencies
        
        String string = "geeksforgeeks";
        String search = "skee";
        
        Boolean result = SearchAnagram(string,search);

        System.out.println(result);
    }

    private static Boolean SearchAnagram(String string, String search) {
        
        char[] countString = new char[MAX];
        char[] countSearch = new char[MAX];

        int lenString = string.length();
        int lenSearch = search.length();

        for (int i = 0; i < lenSearch; i++) {
            (countSearch[search.charAt(i)])++;
            (countString[string.charAt(i)])++;
        }

        for (int i = lenSearch; i < lenString; i++) {
            if(AreSame(countString, countSearch))
                return true;
            countString[string.charAt(i)]++;
            countString[string.charAt(i - lenSearch)]--;

        }
        return false;
        
    }

    private static boolean AreSame(char[] countString, char[] countSearch) {

        for (int i = 0; i < MAX; i++) {
            if(countString[i] != countSearch[i])
                return false;
            }
            return true;
        }
    }
