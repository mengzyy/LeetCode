package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-06 10:28
 **/
public class lt983 {
    public int mincostTickets(int[] days, int[] costs) {


        int n = days.length;
        int[] dp = new int[days[n - 1] + 1];
        int firstDay = days[0];
        int[] book = new int[days[n - 1] + 1];
        for (int i = 0; i < days.length; i++) {
            book[days[i]] = 1;
        }
        dp[0] = 0;
        for (int i = 1; i < book.length; i++) {
            if (book[i] == 1) {
                //选择一天的
                if (dp[i] == 0) {
                    int len = 0;
                    if (costs[0] == Math.min(costs[0], Math.min(costs[1], costs[2]))) {
                        dp[i] = dp[i - 1] + costs[0];
                    }
                    if (costs[1] == Math.min(costs[0], Math.min(costs[1], costs[2]))) {
                        dp[i] = dp[i - 1] + costs[1];
                        len = 6;
                    }
                    if (costs[2] == Math.min(costs[0], Math.min(costs[1], costs[2]))) {
                        dp[i] = dp[i - 1] + costs[2];
                        len = 29;
                    }
                    for (int j = 1; j <= len; j++) {
                        if (i + j < book.length)
                            dp[i + j] = dp[i];
                    }

                }
                //选择7天的
                if (i - 6 - firstDay >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
                }
                if (i - 6 - firstDay < 0 && dp[i] > dp[firstDay - 1] + costs[1]) {
                    dp[i] = dp[firstDay - 1] + costs[1];
                    int len = 7 - i;
                    for (int k = 1; k <= len; k++) {
                        if (i + k < book.length)
                            dp[i + k] = dp[i];
                    }
                }

                if (i - 29 - firstDay >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
                }
                if (i - 29 - firstDay < 0 && dp[i] > dp[firstDay - 1] + costs[2]) {
                    dp[i] = dp[firstDay - 1] + costs[2];
                    int len = 30 - i;
                    for (int k = 1; k <= len; k++) {
                        if (i + k < book.length)
                            dp[i + k] = dp[i];
                    }
                }
            } else {
                if (dp[i] == 0)
                    dp[i] = dp[i - 1];
            }
        }
        return dp[days[n - 1]];


    }

    public static void main(String[] args) {

        new lt983().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15});
    }
}
