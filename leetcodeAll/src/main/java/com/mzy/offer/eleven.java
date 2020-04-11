package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-02 14:16
 **/


/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class eleven {
    public int NumberOf1(int n) {


        int x = 1;
        int count = 0;
        while (x != 0) {

            int i = n & x;
            if (i != 0) {
                count++;
            }
            x = x << 1;


        }
        return count;


    }
}
