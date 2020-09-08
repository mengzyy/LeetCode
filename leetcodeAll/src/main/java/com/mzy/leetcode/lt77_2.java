package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-08 12:57
 **/
public class lt77_2 {
    static List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n, 1, new ArrayList<>(), k);
        return res;

    }

    private void dfs(int n, int ind, ArrayList<Integer> temp, int k) {
        if (temp.size() == k) {
            /*add*/
            List<Integer> list = new ArrayList<>();
            for (Integer o : temp) {
                list.add(o);
            }
            res.add(list);
        }
        for (int i = ind; i <= n; i++) {
            temp.add(i);
            dfs(n, i + 1, temp, k);
            temp.remove(temp.size() - 1);

        }

    }
}
