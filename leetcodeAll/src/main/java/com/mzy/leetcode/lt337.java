package com.mzy.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class lt337 {

    /*如果根节点偷 root + 子节点不偷
     * 如果根节点不偷 + 子节点偷
     * */
    public static Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        //如果根节点偷
        int max1 = root.val;
        if (root.left != null && root.left.left != null) {
            if (map.containsKey(root.left.left)) max1 += map.get(root.left.left);
            else {
                int leftLeft = rob(root.left.left);
                max1+=leftLeft;
                map.put(root.left.left, leftLeft);
            }
        }
        if (root.left != null && root.left.right != null) {
            if (map.containsKey(root.left.right)) max1 += map.get(root.left.right);
            else {
                int leftRight = rob(root.left.right);
                max1+=leftRight;
                map.put(root.left.right, leftRight);
            }
        }
        if (root.right != null && root.right.left != null) {
            if (map.containsKey(root.right.left)) max1 += map.get(root.right.left);
            else {
                int rightLeft = rob(root.right.left);
                max1+=rightLeft;
                map.put(root.right.left, rightLeft);
            }
        }
        if (root.right != null && root.right.right != null) {
            if (map.containsKey(root.right.right)) max1 += map.get(root.right.right);
            else {
                int rightRight = rob(root.right.right);
                max1+=rightRight;
                map.put(root.right.right, rightRight);
            }
        }
        //如果根节点不偷
        int max2 = 0;
        if (root.left != null) {
            if (map.containsKey(root.left)) max2 += map.get(root.left);
            else {
                int left = rob(root.left);
                max2+=left;
                map.put(root.left, left);
            }
        }
        if (root.right != null) {
            if (map.containsKey(root.right)) max2 += map.get(root.right);
            else {
                int right = rob(root.right);
                max2+=right;
                map.put(root.right, right);
            }
        }
        return Math.max(max1, max2);


    }


}
