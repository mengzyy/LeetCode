package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-03 10:22
 **/
public class lt51_2 {
    static List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        int[] tAns = new int[n];
        for (int i = 0; i < tAns.length; i++) {
            tAns[i] = -1;
        }
        res = new ArrayList<>();
        dfs(0, n, tAns);
        return res;
    }

    private void dfs(int ind, int n, int[] tAns) {
        if (ind == n) {
            List<String> t = new ArrayList<>();
            for (int tAn : tAns) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tAn; i++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int i = 0; i < n - 1 - tAn; i++) {
                    sb.append(".");
                }
                t.add(sb.toString());
            }
            res.add(t);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(i, ind, tAns)) {
                    tAns[ind] = i;
                    dfs(ind + 1, n, tAns);
                    tAns[ind] = -1;
                }
            }
        }
    }

    private boolean isValid(int tar, int ind, int[] tAns) {
        for (int i = 0; i <= ind - 1; i++) {
            int abs = Math.abs(tAns[i] - tar);
            if (abs == ind - i || abs == 0) return false;
        }
        return true;


    }
}
