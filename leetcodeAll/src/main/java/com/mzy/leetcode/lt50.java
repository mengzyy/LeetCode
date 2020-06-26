package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-11 11:02
 **/
public class lt50 {
    public double myPow(double x, int n) {
        long  m=n;
        if(n<0)m=-m;
        double res = 1.0;
        while (m > 0) {
            if (m % 2 != 0) {
                res *= x;
            }
            x *= x;
            m /= 2;
        }
        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {


        System.out.println(new lt50().myPow(2, -2147483648));


    }
}
