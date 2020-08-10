package com.mzy.leetcode;

/**
 * @description:
 * @author: Meng ZhongYi
 * @create: 2020-08-07 09:09
 **/
public class lt100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*出口*/
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        /*p和q的val相等*/
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
