package com.mzy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-10 12:38
 **/
public class lt151 {
    public static String reverseWords(String s) {

        if (s == null || s.length() == 0) return s;
        String trim = s.trim();
        String[] split = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 1; i--) {
            sb.append(split[i]);
            sb.append(" ");

        }
        sb.append(split[0]);
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = reverseWords("  hello world!  ");
        System.out.println(s);


    }

}
