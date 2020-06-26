package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-10 10:43
 **/
public class lt236 {
    static TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        res = null;
        findNode(root, p, q);
        return res;


    }

    private void findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            if (root.val == p.val || root.val == q.val) {
                res = root;
            } else {
                boolean hasLeft = findOneNode(root.left, p, q);
                boolean hasRight = findOneNode(root.right, p, q);
                if (hasLeft && hasRight) {
                    res = root;
                } else {
                    if (hasLeft) findNode(root.left, p, q);
                    if (hasRight) findNode(root.right, p, q);
                }
            }
        }
    }

    private boolean findOneNode(TreeNode root, TreeNode p, TreeNode q) {

        if (root != null) {
            if (root.val == p.val || root.val == q.val) return true;
            else {
                return findOneNode(root.left, p, q) || findOneNode(root.right, p, q);
            }
        }
        return false;


    }
}
