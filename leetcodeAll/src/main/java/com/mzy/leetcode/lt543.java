package com.mzy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Meng ZhongYi
 * @create: 2020-08-07 12:44
 **/
public class lt543 {
    public static int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        return dfs(root);
//        return max;


    }

    private int dfs(TreeNode root) {
        /*叶子节点直接返回0*/
        if (root.left == null && root.right == null) return 0;

        int leftMaxPath = root.left == null ? 0 : dfs(root.left) + 1;
        int rightMaxPath = root.right == null ? 0 : dfs(root.right) + 1;

        /*保存当前节点最大值*/
        max = Math.max(max, leftMaxPath + rightMaxPath);

        /*要想想dfs本身返回的是什么*/
        return Math.max(leftMaxPath, rightMaxPath);
    }

}
