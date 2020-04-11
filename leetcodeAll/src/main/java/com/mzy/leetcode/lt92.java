package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-11 19:11
 **/
public class lt92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode root = new ListNode(-1);
        root.next = head;
        int firstLen = m - 1;
        ListNode work = root;
        while (firstLen != 0) {
            work = work.next;
            firstLen--;
        }
        ListNode right = work.next;
        int secondLen = n - m;
        while (secondLen != 0) {
            ListNode temp = right.next;
            right.next = right.next.next;
            temp.next = null;
            //头插
            temp.next = work.next;
            work.next = temp;
            secondLen--;
        }
        return root.next;


    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        reverseBetween(root, 2, 4);
    }
}
