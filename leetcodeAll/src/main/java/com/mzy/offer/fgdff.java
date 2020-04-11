package com.mzy.offer;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 16:09
 **/
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/*
1.有右子树的话，右子树的最左节点
2.有左子树的话，返回父节点
3.为叶节点的话 ，需要迭代判断父节点的情况
 */
public class fgdff {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null) return null;

        if (pNode.right != null) {
            TreeLinkNode work = pNode.right;
            while (work.left != null) {
                work = work.left;
            }
            return work;

        } else if (pNode.left != null) {
            return pNode.next;

        } else {
            TreeLinkNode parent = pNode.next;

            if (parent == null) return null;
            if (parent.left == pNode) {
                return parent;
            } else if (parent.right == pNode) {
                while (parent.next != null) {
                    TreeLinkNode chil = parent;
                    parent = parent.next;
                    if (parent.left == chil) {
                        return parent;
                    }
                }
            }

        }
        return null;
    }
}
