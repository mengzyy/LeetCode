package com.mzy.leetcode;

import com.mzy.offer.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-08-31 23:14
 **/
public class offer34 {
    List<List<Integer>> lists;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists = new ArrayList<>();
        if (root == null) return lists;
        List<Integer> t = new ArrayList<>();
        t.add(root.val);
        dfs(root, t, root.val, sum);
        return lists;

    }

    private void dfs(TreeNode root, List<Integer> tList, int temp, int sum) {

        if (root != null) {
            if (temp == sum&&root.left==null&&root.right==null) {
                List<Integer> list = new ArrayList<>();
                for (Integer integer : tList) {
                    list.add(integer);
                }
                lists.add(list);
            }
            if (root.left != null) {
                tList.add(root.left.val);
                dfs(root.left, tList, temp + root.left.val, sum);
                tList.remove(tList.size() - 1);
            }

            if (root.right != null) {
                tList.add(root.right.val);
                dfs(root.right, tList, temp + root.right.val, sum);
                tList.remove(tList.size() - 1);
            }
        }
    }
}
