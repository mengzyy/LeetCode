package com.mzy.leetcode.compest179;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 10:15
 **/
public class no1 {
    public String generateTheString(int n) {
        if (n == 0) return "";

        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");

            }
            sb.append("b");
        } else {
            for (int i = 0; i < n; i++) {
                sb.append("a");

            }
        }
        return sb.toString();

    }
}
