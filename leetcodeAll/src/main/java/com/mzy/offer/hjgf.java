package com.mzy.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-08 16:03
 **/
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
 */




public class hjgf {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.add(root);
        while (queue.size() != 0) {
            //队列头节点出队
            TreeNode poll = queue.poll();
            res.add(poll.val);
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);


        }
        return res;


    }
}
