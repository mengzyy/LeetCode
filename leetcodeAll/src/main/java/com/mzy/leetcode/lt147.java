package com.mzy.leetcode;

import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-13 11:41
 **/
public class lt147 {
    public ListNode insertionSortList(ListNode head) {

        ListNode ans = head;
        ListNode min = head;
        ListNode now = head;
        ListNode work = head;
        while (true) {
            while (work != null) {
                min = work.val < min.val ? work : min;
                work = work.next;
            }
            swap(now, min);
            if (now.next == null) break;
            work = now.next;
            min = now.next;
            now = now.next;


        }
        return ans;

    }

    private void swap(ListNode now, ListNode min) {
        int t = now.val;
        now.val = min.val;
        min.val = t;
    }
}
