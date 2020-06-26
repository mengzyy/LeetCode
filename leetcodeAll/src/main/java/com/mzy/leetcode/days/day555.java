package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-04 18:50
 **/
public class day555 {
    public int[] productExceptSelf(int[] nums) {
        int leftPrefix = 1;
        int rightPrefix = 1;
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftPrefix;
            leftPrefix *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightPrefix;
            rightPrefix *= nums[i];
        }
        return res;


    }
}
