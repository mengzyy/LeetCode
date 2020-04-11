package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-03 13:09
 **/
public class test {

    public static ListNode ReverseList(ListNode head) {


        if (head == null) return null;
        if (head.next == null) return head;

        //建立一个头节点，，不然无法进行头插入
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode current = head.next;
        root.next.next=null;


        while (current != null) {
            ListNode next = current.next;
            current.next = null;

            //头插法
            ListNode temp = root.next;
            root.next = current;
            current.next = temp;


            //迭代
            current = next;


        }
        return root.next;


    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);


        ReverseList(head);
    }
}
