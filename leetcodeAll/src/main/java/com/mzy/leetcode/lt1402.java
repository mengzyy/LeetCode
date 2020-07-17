package com.mzy.leetcode;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-06 13:
 **/
public class lt1402 {
    public int maxSatisfaction(int[] satisfaction) {


        Arrays.sort(satisfaction);
        int tempsum = 0;
        int ans = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            tempsum += satisfaction[i];
            if (tempsum < 0) break;
            ans += tempsum;

        }

        return ans;

    }

    public static void main(String[] args) {


    }
}
