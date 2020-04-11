package com.mzy.leetcode;

import java.util.PriorityQueue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-08 20:19
 **/
public class lt215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return -1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i <= k - 1) {
                priorityQueue.offer(nums[i]);
            } else {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }

        }
        return priorityQueue.peek();


    }
}
