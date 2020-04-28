package com.mzy.leetcode.bisai;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 14:19
 **/
public class Main1 {
    public int minCount(int[] coins) {
        if (coins == null || coins.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            res += coins[i] / 2 + (coins[i] % 2 == 0 ? 0 : 1);

        }
        return res;

    }
}
