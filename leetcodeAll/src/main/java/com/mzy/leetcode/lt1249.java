package com.mzy.leetcode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-22 11:25
 **/
public class lt1249 {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        //-1的话为不加入
        int[] book = new int[n];
        for (int i = 0; i < n; i++) {
            char temp = chars[i];
            if (temp == '(') {
                stack.push(i);
            } else if (temp == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    book[i] = -1;
                }
            }
        }
        for (Integer integer : stack) {
            book[integer] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (book[i] == 0) sb.append(s.charAt(i));
        }
        return sb.toString();


    }
}
