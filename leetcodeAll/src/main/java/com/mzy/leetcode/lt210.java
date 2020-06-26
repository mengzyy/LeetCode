package com.mzy.leetcode;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-17 18:18
 **/
public class lt210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //入度表
        int[] inDeep = new int[numCourses];
        //邻接表
        HashMap<Integer, List<Integer>> linkedMap = new LinkedHashMap<>();
        //访问表
        int[] book = new int[numCourses];
        //队列
        Queue<Integer> queue = new LinkedList<>();
        //res
        List<Integer> ans = new LinkedList<>();
        //build
        for (int[] prerequisite : prerequisites) {
            int start = prerequisite[1];
            int end = prerequisite[0];
            //end入度++
            inDeep[end]++;
            //邻接表
            if (!linkedMap.containsKey(start)) {
                List<Integer> table = new LinkedList<>();
                table.add(end);
                linkedMap.put(start, table);
            } else {
                linkedMap.get(start).add(end);
            }

        }
        //初始入队
        for (int i = 0; i < inDeep.length; i++) {
            if (inDeep[i] == 0) {
                queue.offer(i);
                ans.add(i);
                book[i] = 1;
            }
        }
        if (queue.size() == 0) return new int[0];
        //bfs
        while (queue.size() != 0) {
            int len = queue.size();
            while (len != 0) {
                int poll = queue.poll();
                //检查邻接表对应的入度减一
                if (linkedMap.containsKey(poll)) {
                    List<Integer> list = linkedMap.get(poll);
                    for (Integer integer : list) {
                        inDeep[integer]--;
                        if (book[integer] == 0 && inDeep[integer] == 0) {
                            //入队
                            queue.offer(integer);
                            ans.add(integer);
                            book[integer] = 1;
                        }
                    }
                }
                len--;
            }
        }
        if (ans.size() != numCourses) return new int[0];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(i);
        }
        return res;


    }
}
