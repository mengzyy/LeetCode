package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-24 15:30
 **/
public class lt105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        int n = preorder.length;
        TreeNode res = buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        return res;


    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start1, int end1, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }
        if (start1 == end1) {
            TreeNode res = new TreeNode(preorder[start1]);
            return res;
        } else {
            //建立根节点
            TreeNode root = new TreeNode(preorder[start1]);
            int mid = findIndex(inorder, preorder[start1]);
            root.left = buildTree(preorder, inorder, start1 + 1, start1 + mid - start2, start2, mid - 1);
            root.right = buildTree(preorder, inorder, start1 + mid - start2 + 1, end1, mid + 1, end2);
            return root;
        }
    }

    private int findIndex(int[] inorder, int i) {

        for (int j = 0; j < inorder.length; j++) {
            if (inorder[j] == i) return j;

        }
        return 0;
    }

    public static void main(String[] args) {

        new lt105().buildTree(new int[]{1, 2}, new int[]{2, 1});
    }


}
