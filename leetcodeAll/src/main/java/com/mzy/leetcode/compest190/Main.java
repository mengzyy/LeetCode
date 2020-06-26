package com.mzy.leetcode.compest190;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-24 10:30
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static int res;

    public int pseudoPalindromicPaths(TreeNode root) {
        res = 0;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        dfs(root, list);
        return res;

    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            res += isConStr(list) ? 1 : 0;
        } else {
            if (root.left != null) {
                list.add(root.left.val);
                dfs(root.left, list);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                list.add(root.right.val);
                dfs(root.right, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isConStr(List<Integer> list) {

        int[] t = new int[10];
        for (Integer integer : list) {
            t[integer]++;
        }
        int odd = 0;
        for (int i : t) {
            if (i % 2 != 0) odd++;
        }
        return odd <= 1;


    }

}
