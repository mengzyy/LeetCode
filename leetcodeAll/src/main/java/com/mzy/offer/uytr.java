package com.mzy.offer;

import java.util.Map;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 12:34
 **/
/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class uytr {
    public static boolean flag;

    public boolean IsBalanced_Solution(TreeNode root) {
        flag = true;
        IsBalanced_Solution2(root);
        boolean temp = flag;

        flag = true;

        return temp;

    }


    public int IsBalanced_Solution2(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        } else {

            int leftdeep = 0;
            int rightdeep = 0;
            if (root.left != null) {
                leftdeep = IsBalanced_Solution2(root.left);
            }
            if (root.right != null) {
                rightdeep = IsBalanced_Solution2(root.right);
            }
            if (Math.abs(leftdeep - rightdeep) > 1) {
                flag = false;
            }

            return leftdeep > rightdeep ? leftdeep + 1 : rightdeep + 1;
        }

    }


}
