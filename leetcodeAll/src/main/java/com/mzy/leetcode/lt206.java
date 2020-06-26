package com.mzy.leetcode;

import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-04 18:57
 **/


public class lt206 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        //头节点
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode work = head;

        while (work.next != null) {
            ListNode temp = work.next;
            work.next = work.next.next;
            temp.next = null;

            temp.next = root.next;
            root.next = temp;

        }
        return root.next;
    }
}
