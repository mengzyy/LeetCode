package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-26 10:13
 **/
public class lt83 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode pre = head.next;
        ListNode pro = head;
        ListNode res = head;

        while (pre != null) {
            if (pro.val != pre.val) {
                pre = pre.next;
                pro = pro.next;

            } else {
                pro.next = pro.next.next;
                pre = pre.next;
            }

        }
        return res;


    }
}
