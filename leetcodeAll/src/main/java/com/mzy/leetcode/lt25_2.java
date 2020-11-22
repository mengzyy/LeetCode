package com.mzy.leetcode;

import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-10 18:35
 **/
public class lt25_2 {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) return head;
        /*建立头节点*/
        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode work = root;
        while (work.next != null) {
            /*标记一下头节点*/
            ListNode tFirst = work;
            ListNode tWork = tFirst.next;
            ListNode tDel = tFirst.next.next;
            int path = k - 1;
            boolean hasOver = false;
            while (path != 0) {
                ListNode temp = tDel;
                if (tWork.next != null) {
                    tWork.next = tWork.next.next;
                } else {
                    hasOver = true;
                    break;
                }
                temp.next = work.next;
                work.next = temp;
                tDel = tWork.next;
                path--;
            }
            /*复原尾节点*/
            if (hasOver) {
                tWork = tFirst.next;
                while (tWork.next != null) {
                    ListNode temp2 = tWork.next;
                    tWork.next = tWork.next.next;
                    temp2.next = tFirst.next;
                    tFirst.next = temp2;
                }
                break;

            }
            work = tWork;

        }
        return root.next;


    }
}
