package com.mzy.offer;

import java.util.ArrayList;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-08 14:03
 **/
public class ttgrfds {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int n = pushA.length;
        if (n == 0) return false;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < n; i++) {
            stack.add(pushA[i]);
            while (stack.isEmpty() == false && stack.get(stack.size() - 1) == popA[j]) {
                stack.remove(stack.size() - 1);
                j++;
            }
        }
        return stack.isEmpty();
    }


}
