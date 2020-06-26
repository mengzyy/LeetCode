package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-09 15:53
 **/
public class lt121 {
    public int maxProfit(int[] prices) {

        int max = 0;
        int buy = -1;
        for (int price : prices) {
            if (buy == -1 || buy > price) {
                buy = price;
            }else{
                max = Math.max(price - buy, max);
            }

        }

        return max;


    }
}
