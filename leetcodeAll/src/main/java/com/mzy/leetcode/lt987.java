package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-08-30 17:04
 **/
public class lt987 {

    public static int maxTurbulenceSize(int[] A) {

        int n = A.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < A.length; i++) {
            int pre = dp[i - 1];
            int val = A[i];
            if (pre == 1) {
                dp[i] = val == A[i - 1] ? 1 : 2;
            } else {
                if (A[i - 1] > A[i - 2] && A[i - 1] > val) {
                    dp[i] = pre + 1;
                } else if (A[i - 1] < A[i - 2] && A[i - 1] < val) {
                    dp[i] = pre + 1;
                } else {
                    dp[i] = val == A[i - 1] ? 1 : 2;
                }
            }
            ans = Math.max(ans, dp[i]);

        }
        return ans;

    }

    public static int maxTurbulenceSize2(int[] A) {
        int preDp = 1;
        int ans = 1;
        for (int i = 1; i < A.length; i++) {
            int now;
            int val = A[i];
            if (preDp == 1) {
                now = val == A[i - 1] ? 1 : 2;
            } else {
                if (A[i - 1] > A[i - 2] && A[i - 1] > val) {
                    now = preDp + 1;
                } else if (A[i - 1] < A[i - 2] && A[i - 1] < val) {
                    now = preDp + 1;
                } else {
                    now = val == A[i - 1] ? 1 : 2;
                }
            }
            ans = Math.max(ans, now);
            preDp = now;
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] a = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int i = maxTurbulenceSize(a);
        System.out.println(i);
    }
}
