package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-22 20:18
 **/
public class rf {

    TreeNode res;
    int K;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;

        K = k;
        KthNode2(pRoot);
        return res;


    }

    private void KthNode2(TreeNode pRoot) {
        if (K > 0) {
            if (pRoot.left == null && pRoot.right == null) {
                //为叶子节点
                K--;
                if (K == 0) res = pRoot;
            } else {
                if (pRoot.left != null) KthNode2(pRoot.left);
                K--;
                if (K == 0) res = pRoot;
                if (pRoot.right != null) KthNode2(pRoot.right);
            }


        }
    }
}
