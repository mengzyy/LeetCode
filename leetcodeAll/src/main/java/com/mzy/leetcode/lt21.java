package com.mzy.leetcode;


public class lt21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode onefirst = l1;
        ListNode twofirst = l2;

        ListNode first = new ListNode(0);
        ListNode res = first;

        while (onefirst != null || twofirst != null) {
//            if (twofirst == null || onefirst.val <= twofirst.val) {
//
//                first.next = onefirst;
//                first = first.next;
//                onefirst = onefirst.next;
//            }
//
//            if (onefirst == null || twofirst.val <= onefirst.val) {
//
//                first.next = twofirst;
//                first = first.next;
//                twofirst = twofirst.next;
//            }


            if (onefirst == null) {
                first.next = twofirst;
                twofirst = twofirst.next;
            } else if (twofirst == null) {
                first.next = onefirst;
                onefirst = onefirst.next;
            } else if (onefirst.val <= twofirst.val) {
                first.next = onefirst;
                onefirst = onefirst.next;
            } else {
                first.next = twofirst;
                twofirst = twofirst.next;

            }
            first = first.next;


        }


        return res.next;


    }

    public static void main(String[] args) {


    }
}
