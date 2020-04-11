package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 10:08
 **/
public class lt70 {
    public int climbStairs(int n) {

        if(n<=0)return n;
        if(n==1)return 1;
        if(n==2)return 2;

        int a=1;
        int b=2;
        for (int i = 0; i < n - 2; i++) {
            int temp = a;
            a =b;
            b =temp+b;
        }
        return b;

    }

    public static void main(String[] args) {


        System.out.println(new lt70().climbStairs(4));
    }
}
