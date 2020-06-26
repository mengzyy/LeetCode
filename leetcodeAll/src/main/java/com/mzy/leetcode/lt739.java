package com.mzy.leetcode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-11 11:49
 **/
public class lt739 {
    public int[] dailyTemperatures(int[] T) {
        //单调递减栈
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            //add
            stack.push(i);
        }

        while (!stack.isEmpty()) res[stack.pop()] = 0;
        return res;


    }
}
