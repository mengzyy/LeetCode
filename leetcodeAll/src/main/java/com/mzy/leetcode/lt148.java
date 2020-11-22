package com.mzy.leetcode;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-09-13 17:23
 **/
public class lt148 {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode ans = head;
        sort(head, null);
        return ans;

    }

    private void sort(ListNode head, ListNode tailPro) {
        if (head == null || head == tailPro || head.next == tailPro) return;
        ListNode mid = partition(head, tailPro);
        sort(head, mid);
        sort(mid.next, tailPro);
    }

    private ListNode partition(ListNode head, ListNode tailPro) {
        ListNode t = head;
        ListNode left = head;
        ListNode right = head.next;
        while (right != tailPro) {
            if (right.val < t.val) {
                left = left.next;
                swap(left, right);
            }
            right = right.next;
        }
        swap(t, left);
        return left;
    }

    private void swap(ListNode left, ListNode right) {
        int t = left.val;
        left.val = right.val;
        right.val = t;
    }

    public static void main(String[] args) {
        lt148 lt148 = new lt148();
        ListNode t = new ListNode(4);
        t.next = new ListNode(2);
        t.next.next = new ListNode(1);
        t.next.next.next = new ListNode(3);
        ListNode node = lt148.sortList(t);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);

    }
}
