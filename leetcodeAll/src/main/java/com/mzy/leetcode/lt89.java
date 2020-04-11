package com.mzy.leetcode;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-09 14:54
 **/
public class lt89 {
    public static List<Integer> grayCode(int n) {

        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("");
        while (stack.size() != 0) {
            String pop = stack.pop();
            if (pop.length() == n) {
                list.add(pop);
                continue;
            } else {
                stack.push(pop + '0');
                stack.push(pop + '1');

            }
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count = 0;
                int n = o1.length();
                for (int i = 0; i < n; i++) {
                    if (o1.charAt(i) == o2.charAt(i)) count++;
                }
                if (count == 1) return -1;
                else if(count==0){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        return null;


    }

    public static void main(String[] args) {
        grayCode(2);

    }
}
