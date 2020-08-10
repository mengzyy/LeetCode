package com.mzy.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:
 * @author: Meng ZhongYi
 * @create: 2020-08-07 09:34
 **/
public class lt1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return isSubTempPath(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);

    }

    private boolean isSubTempPath(TreeNode root, ListNode head) {
        if (head == null) return true;
        if (root == null) return false;
        if (root.val != head.val) return false;
        return isSubTempPath(root.left, head.next) || isSubTempPath(root.right, head.next);
    }


}
