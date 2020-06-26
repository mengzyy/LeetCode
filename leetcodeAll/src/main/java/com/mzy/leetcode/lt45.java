package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 13:19
 **/
public class lt45 {
    public int jump(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[len - 1];


    }

    public int jump2(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = nums[i];
            for (int j = Math.min(i + size,len-1);j >= i + 1; j--) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                } else {
                    break;
                }

            }
        }
        return dp[len - 1];


    }

    public static void main(String[] args) {


        new lt45().jump2(new int[]{2,1});
    }
}
