package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-04 12:36
 **/
public class n07 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int res = 0;
        //使用双指针
        int left = 0;
        int leftBoard = height[left];
        int right = n - 1;
        int rightBoard = height[right];
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftBoard) {
                    leftBoard = height[left];
                } else {
                    res += leftBoard - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightBoard) {
                    rightBoard = height[right];
                } else {
                    res += rightBoard - height[right];
                }
                right--;

            }


        }
        return res;
    }
}
