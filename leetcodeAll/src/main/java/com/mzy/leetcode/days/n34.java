package com.mzy.leetcode.days;

import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-26 09:54
 **/
public class n34 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return mergeKLists(lists, 0, lists.length - 1);


    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {

        if (start == end) return lists[start];
        if (start > end) return null;

        int mid = (start + end) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);

        return merge(left, right);

    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode res = new ListNode(-1);
        ListNode work = res;
        while (a != null || b != null) {
            if (a == null) {
                work.next = b;
                b = b.next;
            } else if (b == null) {
                work.next = a;
                a = a.next;
            } else {
                if (a.val <= b.val) {
                    work.next = a;
                    a = a.next;
                } else {
                    work.next = b;
                    b = b.next;
                }
            }
            work = work.next;
        }
        return res.next;
    }
}
