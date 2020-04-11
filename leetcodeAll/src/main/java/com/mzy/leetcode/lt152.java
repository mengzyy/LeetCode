package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-08 19:48
 **/
public class lt152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int imax = 1;
        int imin = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = imax;
                imax = imin;
                imin = t;
            }
            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);
            max = Math.max(max, imax);

        }
        return imax;

    }
}
