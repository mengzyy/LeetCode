package com.mzy.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-05 11:55
 **/
public class lt84 {
    public int largestRectangleArea(int[] heights) {
        //单调递增栈
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {

            while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                int prev = stack.peek();
                stack.pop();
                // 获取prev的左侧第一个和右侧第一个更小的元素的下标
                int left = stack.empty() ? -1 : stack.peek();  // 为空表示左侧没有更小的元素了
                max = Math.max(max, (i - left - 1) * heights[prev]);
            }
            if (!stack.empty() && heights[stack.peek()] == heights[i]) stack.pop();
            stack.push(i);

        }
        //剩余出栈
        int left, right = heights.length;
        while (!stack.empty()) {
            int prev = stack.peek();
            stack.pop();
            left = stack.empty() ? -1 : stack.peek();
            max = Math.max(max, (right - left - 1) * heights[prev]);
        }

        return max;


    }

    public static void main(String[] args) {

        int i = new lt84().largestRectangleArea(new int[]{2, 1, 2});
        System.out.println(i);
    }
}
