package com.mzy.leetcode.bisai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 15:03
 **/
public class Main2 {
    static int res;

    public int numWays(int n, int[][] relation, int k) {

        if (relation == null || relation.length == 0) return 0;
        HashMap<Integer, List<Integer>> hashMap = new LinkedHashMap<>();
        res = 0;
        int len = relation.length;
        for (int i = 0; i < len; i++) {
            int start = relation[i][0];
            int end = relation[i][1];
            if (!hashMap.containsKey(start)) {
                List<Integer> list = new ArrayList<>();
                list.add(end);
                hashMap.put(start, list);
            } else {
                List<Integer> list = hashMap.get(start);
                list.add(end);
            }

        }

        dfs(hashMap, k, n - 1, 0);
        return res;

    }

    private void dfs(HashMap<Integer, List<Integer>> hashMap, int k, int target, int now) {

        if (k == 0) {
            if (now == target) {
                res++;
            }
        } else {
            if (hashMap.containsKey(now)) {
                int size = hashMap.get(now).size();
                for (int i = 0; i < size; i++) {
                    int nextNow = hashMap.get(now).get(i);
                    if (k - 1 >= 0) dfs(hashMap, k - 1, target, nextNow);
                }

            }


        }
    }
}