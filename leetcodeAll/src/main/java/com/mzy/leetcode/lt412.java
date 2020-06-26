package com.mzy.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-21 17:04
 **/
public class lt412 {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> prefix = new LinkedHashMap<>();
        prefix.put(0, 1);
        return dfs(root, 0, sum, prefix);


    }

    private int dfs(TreeNode root, int curSum, int target, HashMap<Integer, Integer> prefix) {
        if (root == null) return 0;

        int res = 0;
        curSum += root.val;
        if (prefix.containsKey(curSum - target)) {
            res += prefix.get(curSum - target);
        }
        //加入当前前缀
        if (!prefix.containsKey(curSum)) {
            prefix.put(curSum, 1);
        } else {
            prefix.put(curSum, prefix.get(curSum) + 1);
        }
        res += dfs(root.left, curSum, target, prefix);
        res += dfs(root.right, curSum, target, prefix);

        //remove
        prefix.put(curSum, prefix.get(curSum) - 1);
        return res;
    }
}
