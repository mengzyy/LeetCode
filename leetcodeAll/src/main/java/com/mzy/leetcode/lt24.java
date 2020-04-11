package com.mzy.leetcode;

 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class lt24 {



    public static ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        ListNode first = head;
        boolean resboo = true;
        ListNode res = head;

        //需要造一个空节点
        ListNode blank = new ListNode(0);
        blank.next = head;

        while (first != null || first.next != null) {
            ListNode pro = first.next;
            ListNode pre = first;
            pre.next = pro.next;
            pro.next = pre;
            first = first.next;
            blank.next = pro;
            blank = blank.next.next;

            if (resboo) {
                res = pro;
                resboo = false;
            }
        }
        return res;


    }


    //递归解法
    public ListNode swapPairs2(ListNode head) {

        if (head != null && head.next != null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;

        return next;


    }




    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode input = first;
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs(input);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
