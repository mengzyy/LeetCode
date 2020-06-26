package com.mzy.leetcode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-23 13:55
 **/
public class lt67 {
    public String addBinary(String a, String b) {
        int c = 0;
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while (len1 >= 0 || len2 >= 0) {
            int tempA = len1 >= 0 ? Integer.valueOf(String.valueOf(a.charAt(len1))) : 0;
            int tempB = len2 >= 0 ? Integer.valueOf(String.valueOf(b.charAt(len2))) : 0;
            if (tempA + tempB + c == 3) {
                stack.push('1');
                c = 1;
            } else if (tempA + tempB + c == 2) {
                stack.push('0');
                c = 1;
            } else if (tempA + tempB + c == 1) {
                stack.push('1');
                c = 0;
            } else {
                stack.push('0');
            }
            len1--;
            len2--;

        }
        if (c == 1) stack.push('1');
        //reverse
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();

    }

    public static void main(String[] args) {
        String s = new lt67().addBinary("1010", "1011");
        System.out.println(s);


    }

}
