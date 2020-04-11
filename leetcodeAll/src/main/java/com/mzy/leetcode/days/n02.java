package com.mzy.leetcode.days;

import com.mzy.leetcode.lt2;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-30 13:03
 **/


public class n02 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int lastRemaining(int n, int m) {
        if (n <= 1) return n;
        if (m == 1) return n - 1;

        //先构建循环链表
        ListNode a = new ListNode(0);
        ListNode head = a;
        for (int i = 1; i < n; i++) {
            a.next = new ListNode(i);
            a = a.next;
        }
        a.next = head;


        //链表长度（不包括头节点）
        int size = n;
        //工作指针
        ListNode work = head;
        while (size != 1) {
            int footlen = (m-2+size) % size;
            while (footlen != 0) {
                work = work.next;
                footlen--;
            }
            work.next = work.next.next;
            work = work.next;
            size--;
        }
        return work.val;


    }


    public static void main(String[] args) {

        System.out.println(new n02().lastRemaining(5, 3));


    }
}
