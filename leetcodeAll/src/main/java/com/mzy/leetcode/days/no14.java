package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 09:48
 **/
public class no14 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int i = 0;
        int j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            max = max > area ? max : area;

            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return max;

    }


}
