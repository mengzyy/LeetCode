package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-03 14:30
 **/

/*
输入两个单调递增的链表，
输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不减规则。
 */
public class dfd {
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode root = new ListNode(0);
        ListNode res = root;

        while (list1 != null && list2 != null) {

            if (list1.val >= list2.val) {
                root.next = list2;
                root = root.next;
                list2 = list2.next;

            } else {
                root.next = list1;
                root = root.next;
                list1 = list1.next;

            }

        }

        if (list1 != null) {
            root.next = list1;
        }

        if (list2 != null) {
            root.next = list2;
        }


        return res.next;


    }
}
