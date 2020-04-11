package com.mzy.offer;

import java.util.ArrayList;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-01 10:56
 **/


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class three {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) return arrayList;
        return printListFromTailToHead(listNode, arrayList);


    }

    private ArrayList<Integer> printListFromTailToHead(ListNode listNode, ArrayList<Integer> arrayList) {

        if (listNode.next == null) {
            arrayList.add(listNode.val);
            return arrayList;

        }
        ArrayList<Integer> arrayList1 = printListFromTailToHead(listNode.next, arrayList);
        arrayList1.add(listNode.val);
        return arrayList1;


    }


}
