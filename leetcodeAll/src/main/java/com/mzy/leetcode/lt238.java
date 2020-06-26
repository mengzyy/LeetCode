package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-22 13:53
 **/
public class lt238 {
    public int[] productExceptSelf(int[] nums) {

        int left = 1;
        int right = 1;
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left;
            left *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= right;
            right = nums[i];

        }
        return ans;

    }
}
