package com.mzy.leetcode;


import java.lang.reflect.Array;
import java.util.*;

public class lt374 {

    public int[] topKFrequent(int[] nums, int k) {

        /*top k 的问题*/
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }

        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashMap.get(o1) - hashMap.get(o2);
            }
        });
        for (Integer integer : hashMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(integer);
            } else if (hashMap.get(priorityQueue.peek()) < hashMap.get(integer)) {
                priorityQueue.poll();
                priorityQueue.offer(integer);
            }

        }
        int[] ans = new int[k];
        int c = 0;
        for (Integer integer : priorityQueue) {
            ans[c] = integer;
            c++;
        }
        return ans;
    }


}
