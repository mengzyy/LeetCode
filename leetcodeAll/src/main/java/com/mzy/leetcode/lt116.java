package com.mzy.leetcode;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-24 12:01
 **/
public class lt116 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        int len = nums.length;
        for (int i = 0; i <= len - 3; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (min > Math.abs(sum - target)) {
                    min=Math.abs(sum - target);
                    res = sum;
                }
                if (sum == target) return sum;
                if (sum > target) left++;
                if (sum < target) right--;
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int i = new lt116().threeSumClosest(nums,2);
        System.out.println(i);
    }


}
