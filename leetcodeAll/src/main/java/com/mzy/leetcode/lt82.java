package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-10 14:46
 **/


public class lt82 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode left = root;
        ListNode right = head;

        boolean isRepeat = false;
        while (right.next != null) {
            if (right.val != right.next.val) {
                if (!isRepeat) {
                    left = left.next;
                    right = right.next;
                } else {
                    left.next = right.next;
                    right = right.next;
                    isRepeat = false;
                }
            } else {
                isRepeat = true;
                right = right.next;
            }
        }
        if (isRepeat) left.next = null;


        return root.next;


    }
}
