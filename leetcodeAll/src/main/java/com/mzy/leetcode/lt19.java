package com.mzy.leetcode;


import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class lt19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0)
            return null;


        List<ListNode> listnode = new ArrayList<>();
        ListNode firstNode = head;
        ListNode p =head;
        //遍历
        while (firstNode != null) {
            listnode.add(firstNode);
            firstNode = firstNode.next;
        }


        int listsize = listnode.size();
        if (listsize - n > 0) {
            //删除
            ListNode delNode = listnode.get(listnode.size() - n - 1);
            if (listsize - n != listsize) {
                delNode.next = delNode.next.next;
            } else {
                delNode.next = null;
            }
        } else if (listsize - n == 0) {
            return head.next;
        } else {
            return null;
        }


        return p;


    }

    //使用双指针
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }



    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode x =head;
        head.next = new ListNode(2);head=head.next;
        head.next = new ListNode(3);head=head.next;
        head.next = new ListNode(4);head=head.next;
        head.next = new ListNode(5);

        ListNode n = removeNthFromEnd(x, 2);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }


    }


}
