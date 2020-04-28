package com.mzy.leetcode.compest179;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 11:32
 **/
public class n03 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n <= 1) return 0;

        int max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        dp[headID] = 0;
        //使用bfs
        Queue<int[]> queue = new LinkedList<>();

        HashMap<Integer, List<Integer>> tree = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                if (!tree.containsKey(manager[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    tree.put(manager[i], list);
                } else {
                    List<Integer> list = tree.get(manager[i]);
                    list.add(i);
                }
            }
        }
        //初始化
        for (Integer integer : tree.get(headID)) {
            queue.offer(new int[]{headID, integer});

        }
        while (queue.size() != 0) {
            int len = queue.size();
            while (len != 0) {
                int[] poll = queue.poll();
                dp[poll[1]] = dp[poll[0]] + informTime[poll[0]];
                if (tree.containsKey(poll[1])) {
                    for (Integer integer : tree.get(poll[1])) {
                        queue.offer(new int[]{poll[1], integer});

                    }
                }
                len--;
            }
        }
        for (int i : dp) {
            max = max > i ? max : i;

        }
        return max;


    }

    public static void main(String[] args) {

        int i = new n03().numOfMinutes(1, 0, new int[]{-1, 0}, new int[]{0});
        System.out.println(i);
    }
}
