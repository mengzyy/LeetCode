package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-01 09:44
 **/

public class n66 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(-1);
        ListNode work = root;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                work.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                work.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    work.next = l1;
                    l1 = l1.next;
                } else {
                    work.next = l2;
                    l2 = l2.next;
                }
            }
            work = work.next;
        }
        return root.next;

    }

    public static void main(String[] args) {


    }
}
