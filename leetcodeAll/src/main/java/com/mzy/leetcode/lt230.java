package com.mzy.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-04 19:15
 **/
public class lt230 {
    public static int res;
    public static int path;

    public int kthSmallest(TreeNode root, int k) {
        res = Integer.MAX_VALUE;
        path = 0;
        findSmallest(root, k);
        return res;


    }

    private void findSmallest(TreeNode root, int k) {
        if (root != null) {
            if (path != k) findSmallest(root.left, k);
            path++;
            if (path == k) res = root.val;
            if (path != k) findSmallest(root.right, k);


        }


    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode peek = stack.peek();
        while (!stack.isEmpty()) {
            while (peek != null) {
                stack.push(peek.left);
                peek = peek.left;
            }
            TreeNode pop = stack.pop();
            if (--k == 0) return pop.val;
            peek = pop.right;


        }
        return -1;


    }

}
