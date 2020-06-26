package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-21 16:00
 **/
public class lt41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int nowValue = nums[i];
            if (nowValue != i + 1) {
                if (nowValue > len || nowValue <= 0) continue;
                else {
                    nums[i] = nums[nowValue - 1];
                    nums[nowValue - 1] = nowValue;
                    i--;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;

    }

    public static void main(String[] args) {


        int i = new lt41().firstMissingPositive(new int[]{3, 4, -1, 1});
    }
}
