package com.mzy.leetcode;

public class lt104 {
    public static int maxLen;

    public int maxDepth(TreeNode root) {
        maxLen=1;
        if (root == null) return 0;
        countDepth(root, 1);
        return maxLen;
    }

    private void countDepth(TreeNode root, int temp) {
        maxLen = Math.max(maxLen, temp);
        if (root.left != null) countDepth(root.left, temp + 1);
        if (root.right != null) countDepth(root.right, temp + 1);

    }
}
