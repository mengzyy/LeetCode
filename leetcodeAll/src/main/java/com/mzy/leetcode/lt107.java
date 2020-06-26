package com.mzy.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-21 13:19
 **/
public class lt107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> t = new LinkedList<>();
        t.add(root.val);
        stack.push(t);
        while (queue.size() != 0) {

            int len = queue.size();
            List<Integer> tmp = new LinkedList<>();
            while (len != 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    tmp.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    tmp.add(poll.right.val);
                }
                len--;
            }
            if(tmp.size()!=0)stack.push(tmp);

        }
        while (stack.size() != 0) {
            res.add(stack.pop());
        }
        return res;
    }
}
