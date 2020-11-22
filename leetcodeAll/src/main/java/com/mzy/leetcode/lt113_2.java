package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-26 21:23
 **/
public class lt113_2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        dfs(root, temp, res, sum, root.val);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> temp, List<List<Integer>> res, int sum, int tsum) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (tsum == sum) {
                    List<Integer> t = new ArrayList<>();
                    for (Integer integer : temp) {
                        t.add(integer);
                    }
                    res.add(t);
                }
            }

            if (root.left != null) {
                temp.add(root.left.val);
                dfs(root.left, temp, res, sum, tsum + root.left.val);
                temp.remove(temp.size() - 1);
            }

            if (root.right != null) {
                temp.add(root.right.val);
                dfs(root.right, temp, res, sum, tsum + root.right.val);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
