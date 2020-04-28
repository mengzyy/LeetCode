package com.mzy.leetcode.leetcodexx;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-17 13:15
 **/
public class Main4 {
    public String longestPrefix(String s) {
        if (s == null || s.length() == 0) return "";

        int i = 0;
        int j = -1;
        int n = s.length();
        int[] next = new int[n + 1];
        next[0] = -1;
        while (i < n) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return s.substring(0, next[n]);


    }

    public static void main(String[] args) {

        System.out.println(new Main4().longestPrefix("leetoddle"));

    }
}
