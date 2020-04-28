package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-22 15:30
 **/
public class lt36 {


    public boolean isValidSudoku(char[][] board) {

        boolean[][] lines = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '1';
                    int squareIndex = i / 3 * 3 + j / 3;
                    if (lines[value][i] || cols[j][value] || squares[value][squareIndex]) return false;
                    else {
                        lines[value][i] = true;
                        cols[j][value] = true;
                        squares[value][squareIndex] = true;
                    }
                }
            }
        }
        return true;


    }

    public static void main(String[] args) {

    }


}
