package com.mzy.leetcode;

import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-13 12:03
 **/
public class lt109 {
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode p = head;
        ListNode q = head;
        ListNode pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;

    }
}
