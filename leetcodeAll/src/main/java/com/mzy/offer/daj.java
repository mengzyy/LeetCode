package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-03 12:47
 **/

/*

输入一个链表，输出该链表中倒数第k个结点。
 */


public class daj {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {


        if (k <= 0 || head == null) return null;

        ListNode left = head;
        ListNode right = head;

        int count = k - 1;

        while (count != 0) {
            right = right.next;
            if (right == null) {
                return null;
            }
            count--;
        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        return left;


    }

    public static void main(String[] args) {


    }


}
