package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-25 09:09
 **/
public class lt53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        //贪心
        int cusum = nums[0];
        int maxsum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cusum = nums[i] + cusum > nums[i] ? nums[i] + cusum : nums[i];
            maxsum = maxsum > cusum ? maxsum : cusum;
        }
        return maxsum;
    }
}
