package com.mzy.offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-10 13:37
 **/
/*
输入一颗二叉树的根节点和一个整数，
打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class uiy {


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();


        if (root == null) return null;

        FindPath(root, target, new ArrayList<Integer>(), res);
        return res;


    }

    private void FindPath(TreeNode root, int target, ArrayList<Integer> arrayList, ArrayList<ArrayList<Integer>> res) {


        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(arrayList));
        } else {
            if (target - root.val >= 0) {
                arrayList.add(root.val);
                if (root.left != null) {
                    FindPath(root.left, target - root.val, arrayList, res);
                }

                if (root.right != null) {
                    FindPath(root.right, target - root.val, arrayList, res);
                }
                arrayList.remove(arrayList.size() - 1);
            }


        }
    }

}
