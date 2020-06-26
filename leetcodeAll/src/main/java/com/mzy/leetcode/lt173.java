//package com.mzy.leetcode;
//
///**
// * @program: LeetCode
// * @author: mengzy 18306299232@163.com
// * @create: 2020-05-15 14:26
// **/
//public class lt173 {
//    public int calculateMinimumHP(int[][] dungeon) {
//
//
//        int n = dungeon.length;
//        int m = dungeon[0].length;
//
//        int[][] dpHealth = new int[n][m];
//        int[][] dpRemin = new int[n][m];
//
//        dpHealth[0][0] = dungeon[0][0] > 0 ? 0 : dungeon[0][0] + 1;
//        dpRemin[0][0] = dungeon[0][0] > 0 ? dungeon[0][0] : 1;
//
//        for (int i = 1; i < n; i++) {
//            if (dungeon[0][i] >= 0) {
//                dpHealth[0][i] = dpHealth[0][i - 1];
//                dpRemin[0][i] = dpRemin[0][i - 1] + dungeon[0][i];
//            }
//            if (dungeon[0][i] < 0) {
//                dpHealth[0][i] = dpHealth[0][i - 1] + (-dungeon[0][i]) - (dpRemin[0][i - 1] - 1);
//                dpRemin[0][i] = 1;
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            if (dungeon[i][0] >= 0) {
//                dpHealth[i][0] = dpHealth[i - 1][0];
//                dpRemin[i][0] = dpRemin[i - 1][0] + dungeon[i][0];
//            }
//            if (dungeon[i][0] < 0) {
//                dpHealth[i][0] = dpHealth[i - 1][0] + (-dungeon[i][0]) - (dpRemin[i - 1][0] - 1);
//                dpRemin[i][0] = 1;
//            }
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                int  val=dungeon[i][j];
//                if(val>0){
//
//                }
//
//            }
//        }
//
//
//}
