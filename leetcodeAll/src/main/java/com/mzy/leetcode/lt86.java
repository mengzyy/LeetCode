package com.mzy.leetcode;

import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-10 15:38
 **/
public class lt86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode work = head;

        //left尾插
        ListNode left = new ListNode(-1);
        //right尾插
        ListNode right = new ListNode(-1);

        ListNode res = left;
        ListNode res2 = right;

        while (work != null) {
            ListNode temp = work;
            work = work.next;
            temp.next = null;
            if (temp.val < x) {
                left.next = temp;
                left = left.next;
            } else {
                right.next = temp;
                right = right.next;
            }
        }
        left.next = res2.next;

        return res.next;


    }
}
