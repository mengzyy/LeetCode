package com.mzy.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 11:46
 **/
/*

输入一棵二叉树，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */


public class jhgcfx {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftdeep = 0;
        int rightdeep = 0;
        if (root.left != null) {
            leftdeep = TreeDepth(root.left);
        }
        if (root.right != null) {
            rightdeep = TreeDepth(root.right);
        }

        return leftdeep > rightdeep ? leftdeep + 1 : rightdeep + 1;

    }


    //使用队列来实现
    public int TreeDepth2(TreeNode root) {

        if (root == null) return 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();

        //根节点入队
        treeNodes.add(root);

        //初始化变量
        int deep = 0;
        int count = 0;
        int nextcount = 1;
        while (treeNodes.size() != 0) {

            //出队
            TreeNode poll = treeNodes.poll();
            count += 1;
            if (poll.left != null) treeNodes.add(poll.left);
            if (poll.right != null) treeNodes.add(poll.right);

            if (count == nextcount) {
                count = 0;
                deep++;
                nextcount = treeNodes.size();
            }


        }
        return deep;


    }
}
