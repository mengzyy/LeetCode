package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-09 09:17
 **/
public class lt69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int n = x / 2;

        long left = 1;
        long right = n;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (mid * mid == x) return (int)mid;
            else if (mid * mid > x) {
                right = mid - 1;
            } else if ((mid + 1) * (mid + 1) >= x) {
                return (int)mid+1;
            } else {
                left = mid+1;
            }
        }
        return (int)left;

    }

    public static void main(String[] args) {


        System.out.println(new lt69().mySqrt(2147395599));
    }
}
