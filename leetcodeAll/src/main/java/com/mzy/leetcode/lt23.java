package com.mzy.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-26 09:35
 **/
public class lt23 {
    class info {
        int val;
        ListNode node;

        public info(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = 0;
        for (ListNode list : lists) {
            ListNode temp = list;
            while (temp != null) {
                len++;
                temp = temp.next;
            }
        }
        if (len == 0) return null;
        PriorityQueue<info> priorityQueue = new PriorityQueue<>(len, new Comparator<info>() {
            @Override
            public int compare(info o1, info o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                }
                return 0;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                info temp = new info(list.val, list);
                priorityQueue.offer(temp);
            }
        }
        if (priorityQueue.size() == 0) return null;
        ListNode res = new ListNode(-1);
        ListNode work = res;
        while (priorityQueue.size() != 0) {
            info poll = priorityQueue.poll();
            work.next = poll.node;
            work = work.next;
            if (poll.node.next != null) {
                info t = new info(poll.node.next.val, poll.node.next);
                priorityQueue.offer(t);
            }
        }
        return res.next;
    }
}
