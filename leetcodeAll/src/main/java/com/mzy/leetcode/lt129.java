package com.mzy.leetcode;

import com.mzy.offer.dfs;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-06 11:40
 **/
public class lt129 {
    public static int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        String s = String.valueOf(root.val);
        Dfs(root, s);
        return res;


    }

    private void Dfs(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            res += Integer.valueOf(s);
        } else {
            if (root.left != null) Dfs(root.left, s + root.left.val);
            if (root.right != null) Dfs(root.right, s + root.right.val);
        }
    }
}
