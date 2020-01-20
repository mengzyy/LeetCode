package com.mzy.leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class lt20 {

    public static boolean isValid(String s) {
        if (s.length()==0)
            return true;

        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']' && c != ')' && c != '}') {
                stack.push(c);
            } else {
                if (stack.size() != 0) {
                    if (map.get(c) != stack.pop()) return false;
                } else {
                    return false;
                }
            }
        }
        return stack.size()==0;

    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));


    }
}
