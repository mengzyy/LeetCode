package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-14 14:47
 **/
public class lt386 {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, ans);
        }
        return ans;
    }

    private void dfs(int n, int target, List<Integer> ans) {
        if (target > n) return;
        ans.add(target);
        target*= 10;
        for (int i = 0; i < 10; i++) {
            dfs(n, target + i, ans);

        }
    }

}
