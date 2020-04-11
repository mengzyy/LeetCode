package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-03 14:38
 **/

/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class dfs {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            boolean res = false;
            if (root1.val == root2.val) {

                res = doCheck(root1, root2);
            }

            if (!res) {
                res = HasSubtree(root1.left, root2);
            }

            if (!res) {
                res = HasSubtree(root1.right, root2);
            }

            return res;


        }
        return false;


    }

    private static boolean doCheck(TreeNode node1, TreeNode node2) {


        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doCheck(node1.left,node2.left) && doCheck(node1.right,node2.right);


    }

}


