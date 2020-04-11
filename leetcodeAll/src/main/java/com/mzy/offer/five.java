package com.mzy.offer;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-01 12:30
 **/

/*


用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class five {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);

    }

    public int pop() {
        if (stack1.size() != 0) {
            return stack1.pop();
        } else {

            while (stack2.size() != 0) {
                stack1.push(stack2.pop());
            }
            if (stack1.size() != 0) {
                return stack1.pop();
            }
            return -1;


        }


    }

    public static void main(String[] args) {


        five five = new five();
        five.push(1);
        five.push(2);
        five.push(3);
        System.out.println(five.pop());
        System.out.println(five.pop());
        five.push(4);
        System.out.println(five.pop());
        five.push(5);
        System.out.println(five.pop());
        System.out.println(five.pop());
        System.out.println(five.pop());

//        Stack<Integer> stack3 = new Stack<Integer>();
//        stack3.push(1);
//        stack3.pop();
//        System.out.println(stack3.peek());

    }

}
