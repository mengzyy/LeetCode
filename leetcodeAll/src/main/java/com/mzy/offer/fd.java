package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 15:41
 **/
public class fd {

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;

        //建立头节点
        ListNode root = new ListNode(-1);
        root.next = pHead;

        ListNode pre = root;

        ListNode pro = root.next;

        while (pro!=null && pro.next != null) {
            //如果发现相等
            if (pro.val == pro.next.val) {

                while (pro.next != null && pro.val == pro.next.val) {
                    pro = pro.next;
                }

                pre.next = pro.next;
                pro = pro.next;

            } else {
                pre = pre.next;
                pro = pro.next;


            }


        }

        return root.next;


    }

    public static void main(String[] args) {

        ListNode x  = new ListNode(1);
        x.next=new ListNode(1);
        x.next.next = new ListNode(1);

        deleteDuplication(x);

    }


}
