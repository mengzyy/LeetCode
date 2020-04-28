package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-24 16:13
 **/
public class lt106 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder == null || postorder.length == 0) return null;
        int n = postorder.length;
        TreeNode res = buildTree(postorder, inorder, 0, n - 1, 0, n - 1);
        return res;


    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int start1, int end1, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }
        if (start1 == end1) {
            TreeNode res = new TreeNode(postorder[start1]);
            return res;
        } else {
            //建立根节点
            TreeNode root = new TreeNode(postorder[end1]);
            int mid = findIndex(inorder, postorder[end1]);
            root.left = buildTree(postorder, inorder, start1, start1 + mid - start2-1, start2, mid - 1);
            root.right = buildTree(postorder, inorder, start1 + mid - start2, end1 - 1, mid + 1, end2);
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

        new lt106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
    }

}
