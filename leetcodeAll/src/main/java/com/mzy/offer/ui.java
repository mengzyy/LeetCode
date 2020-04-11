package com.mzy.offer;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-08 13:16
 **/

/*
输入两个整数序列，第一个序列表示栈的压入顺序，
请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
//自定义一个结构


public class ui {
    class bookflag {
        int val;
        //0:未入栈 1：入栈了 2:出栈
        int state;

    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0) return false;
        //工作栈
        Stack<bookflag> stack = new Stack<bookflag>();

        bookflag[] bookflags = new bookflag[pushA.length];
        //初始化一下
        for (int i = 0; i < pushA.length; i++) {
            bookflags[i] = new bookflag();

        }
        for (int i = 0; i < bookflags.length; i++) {
            bookflags[i].val = pushA[i];
            bookflags[i].state = 0;
        }


        for (int i = 0; i < popA.length; i++) {

            //寻找对应的bookflag
            int bookindex = findBookflag(popA[i], bookflags);
            if (bookindex == -1) return false;
            if (bookflags[bookindex].state == 0) {
                //将前面的迭代压入栈
                for (int i1 = 0; i1 <= bookindex; i1++) {
                    if (bookflags[i1].state == 0) {
                        bookflags[i1].state = 1;
                        stack.push(bookflags[i1]);
                    }

                }
                bookflag pop = stack.pop();
                pop.state = 2;

                //判断
                if (pop.val != popA[i]) {
                    return false;
                }


            } else if (bookflags[bookindex].state == 1) {
                bookflag pop = stack.pop();
                pop.state = 2;

                //判断
                if (pop.val != popA[i]) {
                    return false;
                }

            } else {
                return false;
            }

        }

        return true;


    }

    private int findBookflag(int i, bookflag[] bookflags) {
        for (int i1 = 0; i1 < bookflags.length; i1++) {
            if (i == bookflags[i1].val) {
                return i1;
            }


        }
        return -1;

    }

    public static void main(String[] args) {


        ui ui = new ui();
        int[] a = {1};
        int[] b = {2};

        boolean b1 = ui.IsPopOrder(a, b);
        System.out.println(b1);

    }


}
