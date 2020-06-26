package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-07 12:09
 **/
public class lt572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //判断根节点是否可以
        if (isRootSubtree(s, t)) return true;
        else if (s.left!=null&&isSubtree(s.left, t)) {
            return true;
        } else {
            return s.right!=null||isSubtree(s.right, t);
        }


    }

    private boolean isRootSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;

        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isRootSubtree(s.left, t.left) && isRootSubtree(s.right, t.right);


    }
}
