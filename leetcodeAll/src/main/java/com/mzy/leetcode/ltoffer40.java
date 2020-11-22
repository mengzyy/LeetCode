package com.mzy.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-10 22:50
 **/
public class ltoffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(arr[i]);
            } else if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);

            }

        }
        int[] ans = new int[k];
        int c = 0;
        for (Integer integer : priorityQueue) {
            ans[c++] = integer;

        }
        return ans;

    }
}
