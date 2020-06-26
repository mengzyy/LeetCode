package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-10 11:39
 **/
public class lt220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums == null || nums.length < k) return false;
        for (int i = 0; i <= nums.length - k; i++) {
            if (Math.abs(nums[i] - nums[i + k - 1]) == t) return true;

        }
        return false;

    }
}
