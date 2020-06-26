package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-13 16:47
 **/
public class lt169 {
    public int majorityElement(int[] nums) {

        int n = nums.length;

        int temp = nums[0];

        int left = 0;
        int right = n - 1;

        while (left < right) {

            while (left < right && nums[right] >=temp) right--;
            if (left < right) nums[left] = nums[right];
            while (left < right && nums[left] <temp) left++;
            if (left < right) nums[right] = nums[left];
        }
        nums[left] = temp;

        return nums[n / 2];

    }

    public static void main(String[] args) {


        new lt169().majorityElement(new int[]{4,5,4});
    }
}
