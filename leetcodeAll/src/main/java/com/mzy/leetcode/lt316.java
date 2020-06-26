package com.mzy.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-16 14:26
 **/
public class lt316 {
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (!stack.contains(temp)) {
                while (!stack.empty() && stack.peek() > temp && s.substring(i + 1).contains(String.valueOf(stack.peek()))) {
                    stack.pop();
                }
                stack.push(temp);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


    }
}
