package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-25 13:00
 **/
public class lt31 {
    public void nextPermutation(int[] nums) {
        if (!(nums == null || nums.length == 0)) {

            for (int i = nums.length - 1; i >= 1; i--) {
                if (nums[i] > nums[i - 1]) {
                    //swap
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    return;
                }

            }
            //倒排
            int count = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 - 1;

            for (int i = 0; i < count; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;

            }


        }


    }
}
