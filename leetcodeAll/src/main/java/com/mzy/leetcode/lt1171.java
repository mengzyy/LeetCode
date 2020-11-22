package com.mzy.leetcode;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-23 15:24
 **/
public class lt1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head == null) return head;
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        int sum = 0;
        for (ListNode start = dummy; start != null; start = start.next) {
            sum += start.val;
            hashMap.put(sum, start);
        }
        sum = 0;
        for (ListNode start = dummy; start != null; start = start.next) {
            sum += start.val;
            start.next = hashMap.get(sum).next;
        }
        return dummy.next;


    }
}
