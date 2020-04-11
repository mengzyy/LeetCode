package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-11 20:08
 **/
public class lt94 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || stack.size() != 0) {
            if (cur != null) {
                //入栈
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop.right;
            }
        }
        return res;


    }


}
