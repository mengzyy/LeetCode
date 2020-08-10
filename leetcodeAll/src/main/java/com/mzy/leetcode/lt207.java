package com.mzy.leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 */

public class lt207 {

    /*list保存入读为0的节点*/
    /**/
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        /*入度表*/
        int[] inCount = new int[numCourses];
        /*邻接表*/
        Map<Integer, List<Integer>> linedTable = new HashMap<>();
        /*访问数组*/
        int[] book = new int[numCourses];
        /*队列*/
        Queue<Integer> queue = new ArrayDeque<>();

        /*init*/
        for (int[] prerequisite : prerequisites) {
            int startNode = prerequisite[0];
            int endNode = prerequisite[1];
            inCount[endNode]++;
            List<Integer> lists = linedTable.computeIfAbsent(startNode, k -> new ArrayList<>());
            lists.add(endNode);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inCount[i] == 0) queue.offer(i);
        }
        while (queue.size() != 0) {
            int poll = queue.poll();
            /*查询对应的邻接表*/
            if (linedTable.get(poll) == null) continue;
            List<Integer> integers = linedTable.get(poll);
            int n = integers.size();
            for (int i = 0; i < n; i++) {
                int nowNode = integers.get(i);
                if (book[nowNode] == 1) continue;
                if (--inCount[nowNode] == 0) {
                    queue.add(nowNode);
                    book[nowNode] = 1;
                }
            }
        }
        for (int i : inCount) {
            if (i != 0) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        boolean b = new lt207().canFinish(2, new int[][]{{1, 0}});
        System.out.println(b);


    }
}

