package com.mzy.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-10 20:38
 **/
public class lt23_2 {
    public ListNode mergeKLists(ListNode[] lists) {


        ListNode root = new ListNode(-1);
        ListNode work = root;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        /*init*/
        for (ListNode list : lists) {
            if(list!=null)priorityQueue.add(list);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            work.next = poll;
            if (poll.next != null) priorityQueue.offer(poll.next);
            work = work.next;
        }
        return root.next;


    }
}
