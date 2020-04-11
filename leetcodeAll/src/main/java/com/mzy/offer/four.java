package com.mzy.offer;


import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-01 11:07
 **/

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class four {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) return null;

        int preleft = 0;
        int preright = pre.length - 1;
        int proleft = 0;
        int proright = in.length - 1;

        return reConstructBinaryTree(pre, in, preleft, preright, proleft, proright);


    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int preleft, int preright, int proleft, int proright) {
        if (preleft > preright || proleft > proright || preleft < 0 || preleft > pre.length - 1 || preright < 0 || preright > pre.length - 1 || proleft < 0 || proleft > in.length - 1 || proright < 0 || proright > in.length - 1) {
            return null;
        }


        if (proleft == proright) {
            return new TreeNode(in[proleft]);
        }

        TreeNode root = new TreeNode(pre[preleft]);
        int index = findindex(in, pre[preleft]);
        root.left = reConstructBinaryTree(pre, in, preleft + 1, index - proleft + preleft, proleft, index - 1);
        root.right = reConstructBinaryTree(pre, in, index - proleft + preleft + 1, preright, index + 1, proright);
        return root;
    }

    private int findindex(int[] in, int i) {
        for (int i1 = 0; i1 < in.length; i1++) {
            if (in[i1] == i) return i1;

        }
        return -1;
    }

    public static void main(String[] args) {


    }


}
