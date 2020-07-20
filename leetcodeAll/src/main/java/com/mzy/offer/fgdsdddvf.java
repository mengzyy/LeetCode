package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 23:21
 **/

/*
1.运用java的短路独特性
 */
public class fgdsdddvf {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = n > 0 && ((sum += Sum_Solution(--n)) > 0);
        return sum;

    }

    public static void main(String[] args) {



    }


}
