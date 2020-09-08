package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-07 18:06
 **/
public class offer44 {
    public static int findNthDigit(int n) {

        if (n == 0) return 0;
        int start = 1;
        long count = 9;
        while (n > count) {
            start++;
            n -= count;
            count = (long) (Math.pow(10, start - 1)) * start * 9;
        }
        /*获得的数字*/
        long ind =  (long)(Math.pow(10, start - 1)) +(long) (n - 1) / (start);

        return String.valueOf(ind).charAt((n - 1) % (start)) - '0';

    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(3));

    }
}
