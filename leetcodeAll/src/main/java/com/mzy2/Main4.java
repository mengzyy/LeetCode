package com.mzy2;


/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-20 10:26
 **/

public class Main4 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;

    }
}
