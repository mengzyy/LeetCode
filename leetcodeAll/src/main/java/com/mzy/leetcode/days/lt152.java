package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-18 10:11
 **/
public class lt152 {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curVal = nums[i];
            int t = max;
            max = Math.max(curVal, Math.max(max * curVal, min * curVal));
            min = Math.min(curVal, Math.min(t * curVal, min * curVal));
            ans = Math.max(ans, Math.max(max, min));
        }
        return max;


    }


}
