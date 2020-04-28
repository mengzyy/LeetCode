package com.mzy.leetcode.leetcodexx;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-17 18:03
 **/
public class KMP {

    public static int f(String s, String target) {

        int n = s.length();
        int m = target.length();
        if (n == 0 || m == 0 || n < m) return -1;

        int[] next = new int[m];
        getNext(next, target);

        int i = 0;
        int j = 0;
        while (i < n && j < m) {

            if (j == -1 || s.charAt(i) == target.charAt(j)) {
                //如果j=-1，那么i向前移动一格，j移动至0，进行匹配
                i++;
                j++;
            } else {
                //i不回溯，j回溯至最长前缀后缀一面一格
                j = next[j];
            }
        }
        //j匹配至最后一个字符
        if (j == m) {
            return i - j;
        } else {
            //没有相同的
            return -1;
        }


    }

    private static void getNext(int[] next, String target) {

        int n = target.length();
        int i = 0;
        int j = -1;
        next[i] = -1;

        while (i < n - 1) {
            if (j == -1 || target.charAt(i) == target.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(f("abaababaabcabd", "abd"));

    }
}
