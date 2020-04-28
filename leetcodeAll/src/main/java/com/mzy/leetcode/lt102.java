package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-24 15:21
 **/
public class lt102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() != 0) {
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (len != 0) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
                len--;
            }
            res.add(temp);
        }
        return res;


    }
}
