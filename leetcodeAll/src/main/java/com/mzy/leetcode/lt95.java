package com.mzy.leetcode;

import com.mzy.offer.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-22 18:04
 **/
public class lt95 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();

        return generateTrees(1, n);


    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;

        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftNodeTree = generateTrees(start, i - 1);
                List<TreeNode> rightNodeTree = generateTrees(i + 1, end);


                for (TreeNode left : leftNodeTree) {
                    for (TreeNode right : rightNodeTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            return res;

        }


    }


}
