package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-05 11:28
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class day099 {
    public static int pre;

    public boolean isValidBST(TreeNode root) {
        pre = -1;
        return dfs(root);


    }

    public boolean dfs(TreeNode root) {
        if (root == null) return true;


        boolean leftVaild = dfs(root.left);
        //中序遍历;
        if (pre == -1) {
            pre = root.val;
        } else {
            if (pre >= root.val) return false;
            else {
                pre = root.val;
            }
        }
        boolean rightVaild = dfs(root.right);

        return leftVaild && rightVaild;


    }

    public static void main(String[] args) {


    }
}
