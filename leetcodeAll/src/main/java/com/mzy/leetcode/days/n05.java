package com.mzy.leetcode.days;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-02 12:03
 **/
public class n05 {


    /*
     *复合状态：0-->1：2：原来是死的但是现在活了（当前计算为0，最后计算为1）
     *          1-->0:  3:原来是活的但是现在死了（当前计算为1，最后计算为0）
     */
    public void gameOfLife(int[][] board) {

        if (!(board == null || board.length == 0)) {

            int n = board.length;
            int m = board[0].length;

            //状态变化数组 记录8个搜索状态
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int liveCount = 0;
                    int selfState = board[i][j];
                    //计算存活数
                    for (int k = 0; k < 8; k++) {
                        int nextI = i + dx[k];
                        int nextJ = j + dy[k];
                        if (nextI >= 0 & nextI <= n - 1 && nextJ >= 0 && nextJ <= m - 1) {
                            if (board[nextI][nextJ] == 1 || board[nextI][nextJ] == 3) liveCount++;
                        }

                    }
                    if (selfState == 1) {
                        if (liveCount < 2 || liveCount > 3) board[i][j] = 3;
                    }
                    if (selfState == 0) {
                        if (liveCount == 3) board[i][j] = 2;
                    }
                }
            }

            //再遍历一次 消除复合状态
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int selfState = board[i][j];
                    if (selfState == 2) board[i][j] = 1;
                    if (selfState == 3) board[i][j] = 0;
                }
            }


        }


    }


}
