package com.mzy.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-24 10:19
 **/
public class lt501 {
    static int pre;
    static int max;
    static int count;
    public int[] findMode(TreeNode root) {
        pre=-1;
        max=-1;
        count=0;
        Set<Integer> ans = new HashSet<>();
        dfs(root, ans);
        int[] res = new int[ans.size()];
        int c=0;
        for (Integer an : ans) {
            res[c++]=an;

        }
        return res;

    }

    /*中序遍历*/
    private void dfs(TreeNode root, Set<Integer> ans) {
        if (root == null) return;
        dfs(root.left, ans);
        /*相等的话*/
        if (pre == -1) {
            pre = root.val;
            count = 1;
            max = count;
            ans.add(root.val);

        } else {
            if (pre == root.val) {
                count++;
                if (count > max) {
                    ans.clear();
                    ans.add(pre);
                    max = count;
                } else if (count == max) {
                    ans.add(pre);
                }
            } else {
                count = 1;
                if (count > max) {
                    ans.clear();
                    ans.add(pre);
                    pre = root.val;
                    max = count;
                } else if (count == max) {
                    ans.add(root.val);
                    pre = root.val;
                    max = count;
                }
            }
        }

        dfs(root.right, ans);

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.left = new TreeNode(2);

        int[] mode = new lt501().findMode(t);
        for (int i : mode) {
            System.out.println(i);
        }
    }
}
