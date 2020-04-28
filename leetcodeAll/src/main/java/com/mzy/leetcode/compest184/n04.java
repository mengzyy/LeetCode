package com.mzy.leetcode.compest184;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 11:29
 **/
public class n04 {
    static int res;

    public int numOfWays(int n) {

        res = 0;
        int[][] a = new int[n][3];

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (i != j && j != k) {
                        a[0][0] = i;
                        a[0][1] = j;
                        a[0][2] = k;
                        bfs(a);
                        //初始化
                        for (int m = 0; m < n; m++) {
                            for (int q = 0; q < 3; q++) {
                                a[m][q] = 0;

                            }

                        }
                    }

                }

            }

        }
        return res;


    }

    private void bfs(int[][] a) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a[0][0], a[0][1], a[0][2]});
        int count = a.length - 1;
        if (count == 0) {
            res++;
            if (res == Math.pow(10, 9) + 7) {
                res = 0;
            }
        }
        while (count != 0) {
            if (queue.size() == 0) break;
            int[] poll = queue.poll();
            int leftup = poll[0];
            int midup = poll[1];
            int rightup = poll[2];
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    for (int k = 1; k <= 3; k++) {
                        if (i != j && j != k && i != leftup && midup != j && rightup != k) {

                            queue.offer(new int[]{i, j, k});
                            count--;
                            if (count == 0) {
                                res++;
                                if (res == Math.pow(10, 9) + 7) {
                                    res = 0;
                                }
                            }
                        }
                    }
                }
            }

        }

    }
}
