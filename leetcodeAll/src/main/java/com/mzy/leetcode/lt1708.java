package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-23 17:04
 **/
public class lt1708 {
    public int bestSeqAtIndex(int[] height, int[] weight) {

        /*sort*/
        List<int[]> infos = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            infos.add(new int[]{height[i], weight[i]});
        }
        Collections.sort(infos, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int n = height.length;
        int ans = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i <n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (infos.get(i)[1] >infos.get(j)[1]&&infos.get(i)[0] >infos.get(j)[0]) max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {65, 70, 56, 75, 60, 68};
        int[] b = {100, 150, 90, 190, 95, 110};
        int i = new lt1708().bestSeqAtIndex(a, b);
        System.out.println(i);

    }
}
