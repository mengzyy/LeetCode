package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-19 12:16
 **/
public class lt131 {
    static List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new LinkedList<>();
        //使用dp数组建立验证集
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        buildVaildSet(dp, n, s);
        dfs(n, s, dp, 0, n - 1, new LinkedList<String>());
        return res;

    }

    private void dfs(int n, String s, boolean[][] dp, int start, int end, List<String> temp) {
        if (start > end) {
            List<String> t = new LinkedList<>();
            for (String s1 : temp) {
                t.add(s1);
            }
            res.add(t);
        } else {
            for (int i = start; i <= end; i++) {
                String spilt = s.substring(start, i+1);
                if (dp[start][i]) {
                    temp.add(spilt);
                    dfs(n, s, dp, i + 1, end, temp);
                    temp.remove(temp.size() - 1);
                }

            }
        }
    }

    private void buildVaildSet(boolean[][] dp, int n, String s) {
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int j = 2; j < n; j++) {
            int newJ = j;
            int newI = 0;
            while (newI < n && newJ < n) {
                dp[newI][newJ] = dp[newI + 1][newJ - 1] && s.charAt(newI) == s.charAt(newJ);
                newI++;
                newJ++;
            }
        }
    }

    public static void main(String[] args) {
        new lt131().partition("aab");
    }
}
