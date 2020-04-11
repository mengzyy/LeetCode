package com.mzy.leetcode.days;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-09 11:48
 **/
class state {
    String s;
    int left;
    int right;

    public state(String s, int left, int right) {
        this.s = s;
        this.left = left;
        this.right = right;
    }

}

public class n010 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return null;
        List<String> res = new ArrayList<>();
        Stack<state> stack = new Stack<>();
        stack.push(new state("", 0, 0));
        while (stack.size() != 0) {
            state pop = stack.pop();
            if (pop.left == pop.right && pop.left == n) {
                res.add(pop.s);
                continue;
            }
            if (pop.left < n) {
                stack.push(new state(pop.s + "(", pop.left + 1, 0));
            }
            if (pop.right < pop.left) {
                stack.push(new state(pop.s + ")", pop.left, pop.right
                        + 1));
            }


        }
        return res;
    }


}