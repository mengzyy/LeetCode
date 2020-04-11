package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-04 10:37
 **/
public class hjkl {
    public void Mirror(TreeNode root) {
        if(root==null)return;


        if (root.left == null && root.right == null) {
            return;
        }

        //当前根节点交换
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);


    }


    public static void main(String[] args) {


    }
}
