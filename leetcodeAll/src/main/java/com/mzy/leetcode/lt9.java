package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 12:57
 **/
public class lt9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int len = -1;
        int t = x;
        while (t != 0) {
            t = t/10;
            len++;
        }
        int t1 = x;
        int t2 = x;
        while (len != 0) {
            //正序
            int a1 = t1 / (int) Math.pow(10, len);
            t1 = t1 % (int) Math.pow(10, len);

            int a2 = t2 / 10;
            t2 = t2 % 10;
            if (a1 != a2) return false;

            len--;
        }
        return true;

    }

    public static void main(String[] args) {
        new lt9().isPalindrome(121);

    }
}
