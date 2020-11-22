package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-23 16:32
 **/
public class lt671 {
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);

    }

    private int dfs(TreeNode root, int val) {
        if (root == null) return -1;
        if (root.val > val) return root.val;

        int left = dfs(root.left, val);
        int right = dfs(root.right, val);

        if (left > val && right > val) {
            return Math.min(left, right);
        }else{
            return Math.max(left,right);
        }
    }
}
