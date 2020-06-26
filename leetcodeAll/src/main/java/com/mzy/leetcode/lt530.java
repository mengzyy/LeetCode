package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-01 09:49
 **/
public class lt530 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int rootVal = root.val;

        //计算左子树最右
        int rootLeft = Integer.MAX_VALUE;
        TreeNode work1 = root.left;
        while (work1 != null) {
            rootLeft = work1.val;
            work1 = work1.right;
        }

        //计算右子数最左
        int rootRight = Integer.MAX_VALUE;
        TreeNode work2 = root.right;
        while (work2 != null) {
            rootRight = work2.val;
            work2 = work2.left;
        }


        int left = getMinimumDifference(root.left);
        int right = getMinimumDifference(root.right);


        return Math.min(Math.abs(rootLeft - rootVal), Math.min(Math.abs(rootRight - rootVal), Math.min(Math.abs(left), Math.abs(right))));
    }
}
