package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-22 09:19
 **/
public class lt199 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<Integer> res;

    //    public List<Integer> rightSideView(TreeNode root) {
//
//        List<Integer> res = new ArrayList<>();
//        if (root == null) return res;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        //根节点入队
//        queue.offer(root);
//        res.add(root.val);
//
//        while (queue.size() != 0) {
//            int len = queue.size();
//            int temp = -1;
//            boolean hasNext = false;
//            while (len != 0) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null) {
//                    queue.offer(poll.left);
//                    temp = poll.left.val;
//                    hasNext = true;
//                }
//                if (poll.right != null) {
//                    queue.offer(poll.right);
//                    temp = poll.right.val;
//                    hasNext = true;
//                }
//                len--;
//            }
//            if (hasNext) res.add(temp);
//        }
//        return res;
//
//
//    }
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;


    }

    private void dfs(TreeNode root, int depth) {
        if (root != null) {
            if (res.size() == depth) {
                res.add(root.val);
            }
            dfs(root.right, depth + 1);
            dfs(root.left, depth + 1);
        }

    }


    public static void main(String[] args) {


    }
}
