package com.mzy.leetcode;

import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-16 10:50
 **/
public class lt25 {
    public ListNode reverseKGroup(ListNode head, int k) {


        int len = 0;
        ListNode work = head;
        while (work != null) {
            len++;
            work = work.next;
        }

        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode left = start;
        ListNode right = start.next.next;

        while (len >= k) {
            int count = k - 1;
            ListNode leftNext = left.next;
            while (count != 0) {
                ListNode next = right.next;

                right.next = left.next;
                left.next = right;

                right = next;
                leftNext.next = right;
                count--;
            }
            len -= k;
            left = leftNext;
            if (left != null && left.next != null) {
                right = left.next.next;
            } else {
                break;
            }
        }
        return start.next;


    }
}
