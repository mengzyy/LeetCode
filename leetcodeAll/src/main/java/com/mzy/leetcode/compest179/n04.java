package com.mzy.leetcode.compest179;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 12:44
 **/
public class n04 {

    static double res;
    static boolean hasRes;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        HashMap<Integer, List<Integer>> tree = new LinkedHashMap<>();
        HashMap<String, Integer> book = new LinkedHashMap<>();
        double[] dp = new double[n + 1];
        //初始化
        for (int[] edge : edges) {
            book.put(edge[0] + "" + edge[1], 0);
            book.put(edge[1] + "" + edge[0], 0);
            if (!tree.containsKey(edge[0])) {
                List<Integer> e = new ArrayList<>();
                e.add(edge[1]);
                tree.put(edge[0], e);
            } else {
                List<Integer> list = tree.get(edge[0]);
                list.add(edge[1]);
            }

            if (!tree.containsKey(edge[1])) {
                List<Integer> e = new ArrayList<>();
                e.add(edge[0]);
                tree.put(edge[1], e);
            } else {
                List<Integer> list = tree.get(edge[1]);
                list.add(edge[0]);
            }


        }
        res = 0;
        hasRes = false;
        dp[1] = 1;
        dfs(tree, book, t, target, 1, dp);
        return res;


    }

    private void dfs(HashMap<Integer, List<Integer>> tree, HashMap<String, Integer> book, int t, int target, int nowNode, double[] dp) {

        if (t == 0 && nowNode == target && !hasRes) {
            res = dp[nowNode];
            hasRes = true;
        } else {
            boolean hasPath = false;
            if (tree.containsKey(nowNode)) {
                for (Integer integer : tree.get(nowNode)) {
                    if (book.get(nowNode + "" + integer) == 0 && !hasRes) {
                        hasPath = true;
                        book.put(nowNode + "" + integer, 1);
                        book.put(integer + "" + nowNode, 1);
                        dp[integer] = dp[nowNode] * (double) (1) / (double) tree.get(nowNode).size();
                        if (t - 1 >= 0) dfs(tree, book, t - 1, target, integer, dp);
                        book.put(nowNode + "" + integer, 0);
                        book.put(integer + "" + nowNode, 0);
                    }

                }
            }
            if (!hasPath && !hasRes) {
                if (t - 1 >= 0) dfs(tree, book, t - 1, target, nowNode, dp);
            }


        }

    }

    public static void main(String[] args) {


        double v = new n04().frogPosition(7, new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}}, 2, 4);
        System.out.println(v);
    }
}
