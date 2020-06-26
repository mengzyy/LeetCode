package com.mzy.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-12 10:19
 **/
public class lt155 {

    private PriorityQueue<Integer> priorityQueue;

    private Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public lt155() {
        priorityQueue = new PriorityQueue<>();
        stack = new Stack<>();

    }

    public void push(int x) {

        this.stack.push(x);
        this.priorityQueue.offer(x);

    }

    public void pop() {
        if (this.stack.size() != 0) {
            int pop = this.stack.pop();
            this.priorityQueue.remove(pop);
        }

    }

    public int top() {
        if (this.stack.size() != 0) {
            return this.stack.peek();
        } else {
            return -1;
        }

    }

    public int getMin() {
        if (this.priorityQueue.size() != 0) {
            return this.priorityQueue.peek();
        } else {
            return -1;
        }

    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
