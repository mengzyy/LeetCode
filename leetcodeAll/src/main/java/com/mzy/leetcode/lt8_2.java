package com.mzy.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-12 15:23
 **/
public class lt8_2 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int n = str.length();
        /*处理空格*/
        int i = 0;
        boolean isPositive = true;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i == str.length()) return 0;
        /*处理正负号*/
        if (str.charAt(i) == '+') i++;
        else if (str.charAt(i) == '-') {
            isPositive = false;
            i++;
        }
        int ans = 0;
        while (i < str.length() && isValid(str.charAt(i))) {
            int num = str.charAt(i) - '0';
            /*判断溢出*/
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && num > 7) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + num;
            i++;
        }
        return isPositive ? ans : -ans;
    }

    private boolean isValid(char charAt) {
        return charAt >= '0' && charAt <= '9';
    }
}
