package com.mzy.leetcode;


/**
 * 1.k%length--实际移动的长度
 * 2.双指针，一个指向尾节点，一个指向需要断开前一个节点
 * 3.特殊情况:
 */

public class lt61 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;
        if (k == 0) return head;
        //间隔
        int length = 1;
        //指针
        ListNode pre = head;
        ListNode pro = head;
        while (pro.next != null) {
            pro = pro.next;
            length++;
        }
        int readK = length - (k % length);

        if(readK!=length) {
            while (readK != 1) {
                pre = pre.next;
                readK--;
            }

            ListNode res = pre.next;
            pre.next = null;
            pro.next = head;
            return res;
        }else {
            return head;
        }


    }

    public static void main(String[] args) {
        lt61 lt61 = new lt61();
        lt61.ListNode head = lt61.new ListNode(1);
        head.next= lt61.new ListNode(2);
        int k = 2;
        lt61.rotateRight(head, 2);


    }
}
