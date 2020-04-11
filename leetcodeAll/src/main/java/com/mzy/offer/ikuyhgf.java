package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-11 10:45
 **/

/*
输入一个复杂链表
（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/*
1.复制链表的兄弟节点
2.构造random系欸但
3.拆分节点
 */
public class ikuyhgf {
    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) return null;

        RandomListNode res = null;

        //复制兄弟节点
        RandomListNode work = pHead;
        while (work != null) {
            RandomListNode temp = work;
            work = work.next;

            RandomListNode insertnode = new RandomListNode(temp.label);
            insertnode.next = temp.next;
            temp.next = insertnode;
        }
        //构造random节点
        RandomListNode work2 = pHead;
        while (work2.next.next != null) {
            RandomListNode temp = work2;
            work2 = work2.next.next;
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
        }

        //分离
        RandomListNode oldnode = pHead;
        RandomListNode newnode = pHead.next;
        res = pHead.next;
        while (newnode.next != null) {
            oldnode.next = oldnode.next.next;
            newnode.next = newnode.next.next;

            oldnode = oldnode.next;
            newnode = newnode.next;

        }

        return res;


    }

    public static void main(String[] args) {

        RandomListNode pHead = new RandomListNode(1);

        pHead.next=new RandomListNode(2);
        pHead.next.next= new RandomListNode(3);
        pHead.next.next.next = new RandomListNode(4);
        pHead.random =pHead.next.next.next;
        pHead.next.next.next.random= pHead;

        ikuyhgf ikuyhgf = new ikuyhgf();
        RandomListNode clone = ikuyhgf.Clone(pHead);


    }
}
