package com.mzy.leetcode;

import java.util.HashSet;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-26 10:03
 **/
public class lt0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode work = head;
        hashSet.add(head.val);
        while (work.next != null) {
            if (hashSet.contains(work.next.val)) {
                //delete
                work.next = work.next.next;
            } else {
                hashSet.add(work.next.val);
                work = work.next;
            }
        }
        return head;


    }
}
