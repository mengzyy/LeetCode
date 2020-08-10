package com.mzy.leetcode;

/**
 * @description:
 * @author: Meng ZhongYi
 * @create: 2020-08-07 11:54
 **/
public class lt160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;

    }
}
