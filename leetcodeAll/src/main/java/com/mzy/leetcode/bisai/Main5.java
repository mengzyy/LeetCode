package com.mzy.leetcode.bisai;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 22:29
 **/
public class Main5 {
    public int minJump(int[] jump) {
        if (jump == null || jump.length == 0) return 0;

        int res = Integer.MAX_VALUE;
        int[] book = new int[jump.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        book[0] = 1;
        int count = 0;
        int max = 0;

        while (queue.size() != 0) {

            count++;
            int len = queue.size();
            while (len != 0) {
                int poll = queue.poll();
                if (poll + jump[poll] >= jump.length) {
                    count--;
                    res = count;
                    return res;
                }
                if (poll + jump[poll] <= jump.length - 1 && book[poll + jump[poll]] == 0) {
                    queue.offer(poll + jump[poll]);
                    book[poll + jump[poll]] = 1;
                }
                for (int i = max; i < poll; i++) {
                    if (book[i] == 0) {
                        queue.offer(i);
                        book[i] = 1;
                    }

                }
                max=poll;
                len--;
            }


        }
        return res;

    }
}
