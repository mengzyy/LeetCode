package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-05 15:46
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class lt103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        int count = 1;

        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> t = new ArrayList<>();
        t.add(root.val);
        res.add(t);
        queue.offer(root);

        while (queue.size() != 0) {


            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (len != 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    temp.add(poll.left.val);
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    temp.add(poll.right.val);
                    queue.offer(poll.right);
                }
                len--;
            }
            List<Integer> temp2 = new ArrayList<>();
            if (count % 2 == 0) {
                for (Integer integer : temp) {
                    temp2.add(integer);

                }
            } else {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    temp2.add(temp.get(i));

                }
            }
            if (temp2.size() != 0)
                res.add(temp2);
            count++;
        }
        return res;

    }
}
