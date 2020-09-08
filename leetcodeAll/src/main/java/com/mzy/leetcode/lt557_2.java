package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-08-30 16:41
 **/
public class lt557_2 {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return null;
        int n = s.length();
        return dfs(s, 0, n - 1).trim();
    }

    private static String dfs(String s, int start, int end) {
        if (start >= s.length()) return "";
        StringBuilder temp = new StringBuilder();
        int next = 0;
        for (next = start; next <= end; next++) {
            if (s.charAt(next) == ' ') {
                break;
            }
            temp.append(s.charAt(next));
        }
        return temp.reverse().toString() + " " + dfs(s, next + 1, end);

    }

    public static void main(String[] args) {
        String s = reverseWords("Let's take LeetCode contest");
        System.out.println(s);

    }
}
