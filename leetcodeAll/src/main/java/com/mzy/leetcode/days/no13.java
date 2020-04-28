package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-17 10:45
 **/
public class no13 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int nowMaxLen = 0;
        int MaxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= MaxLen) {
                nowMaxLen = nums[i] + i;
                if (nowMaxLen > MaxLen) {
                    MaxLen = nowMaxLen;
                }
                if (MaxLen >= nums.length - 1) return true;
            } else {
                return false;
            }

        }
        return false;


    }

    public static boolean a(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }

        return dp[nums.length - 1];
    }


    public static void main(String[] args) {

        boolean b = new no13().a(new int[]{3, 2, 1, 0, 4});
        System.out.println(b);

    }

}
