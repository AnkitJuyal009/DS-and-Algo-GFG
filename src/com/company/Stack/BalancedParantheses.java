package com.company.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParantheses {

    public static void main(String[] args) {
        //I/P: str = "[()]"          O/P: true
        //     str = "(]"            O/P: false

        String str = "(]";
        int len = str.length();

         Boolean result =findBalancedParantheses(str, len);

        System.out.println(result);
    }

    private static Boolean findBalancedParantheses(String s, int len) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if(stack.isEmpty()) {
                return false;
            }

            char last = stack.peek();

            switch (ch) {
                case ')' -> {
                    stack.pop();
                    if (last == '{' || last == '[') {
                        return false;
                    }
                }
                case ']' -> {
                    stack.pop();
                    if (last == '{' || last == '(') {
                        return false;
                    }
                }
                case '}' -> {
                    stack.pop();
                    if (last == '(' || last == '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
