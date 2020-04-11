package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 16:53
 **/
public class vg {

    boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null) return true;
        TreeNode leftNode = pRoot.left;
        TreeNode rightNode = pRoot.right;

        return isSymmetrical(leftNode, rightNode);


    }

    private boolean isSymmetrical(TreeNode leftNode, TreeNode rightNode) {

        if (leftNode == null && rightNode != null || leftNode != null && rightNode == null) {
            return false;
        }
        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode.val != rightNode.val) {
            return false;
        }

        boolean flag1 = isSymmetrical(leftNode.left, rightNode.right);
        boolean flag2 = isSymmetrical(leftNode.right, rightNode.left);

        return flag1 && flag2;

    }
}
