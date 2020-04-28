package com.mzy.leetcode.bisai;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 15:16
 **/
public class Main3 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        if (increase == null || increase.length == 0) return new int[0];

        int n = increase.length;
        int m = requirements.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }

        for (int i = 0; i < m; i++) {
            //二分搜索
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (requirements[i][0] > increase[mid][0] && requirements[i][1] > increase[mid][1] && requirements[i][2] > increase[mid][2]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (requirements[i][0] <= increase[left][0] && requirements[i][1] <= increase[left][1] && requirements[i][2] <= increase[left][2]) {
                if (requirements[i][0] + requirements[i][1] + requirements[i][2] == 0)
                    res[i] = 0;
                else
                    res[i] = left + 1;
            }
        }
        return res;


    }

    public static void main(String[] args) {


    }
}
