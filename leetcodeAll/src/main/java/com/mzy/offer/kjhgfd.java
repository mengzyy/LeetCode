package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-11 11:32
 **/

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class kjhgfd {
    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;


        TreeNode left = pRootOfTree.left;
        TreeNode right = pRootOfTree.right;

        if (left != null) {
            pRootOfTree.left = Convert(left, true, pRootOfTree);

        }

        if (right != null) {
            pRootOfTree.right = Convert(right, false, pRootOfTree);
        }
        return pRootOfTree;


    }

    private TreeNode Convert(TreeNode currentnode, boolean b, TreeNode pRootOfTree) {

        if (currentnode.left == null && currentnode.right == null) {
            currentnode.right = pRootOfTree;
            return currentnode;
        }

        if (currentnode.left != null) {
            currentnode.left = Convert(currentnode.left, true, currentnode);

        }

        if (currentnode.right != null) {
            currentnode.right = Convert(currentnode.right, false, currentnode);
        }

        return currentnode;


    }


}
