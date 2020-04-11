package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-30 14:05
 **/
public class n002 {
    public int lastRemaining(int n, int m) {
        if (n <= 1) return n;


        int p=0;
        for(int i=2;i<=n;i++)
        {
            p=(p+m)%i;
        }
        return p;



    }
}
