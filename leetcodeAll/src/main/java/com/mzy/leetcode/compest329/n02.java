package com.mzy.leetcode.compest329;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-29 10:37
 **/
public class n02 {
    public static int count;

    public int numTeams(int[] rating) {
        if(rating==null||rating.length==0)return 0;
        count = 0;
        //递增搜索
        numTeamsUp(rating, 0, 0, -1);
        //递减搜索
        numTeamsDown(rating, 0, 0, 100001);

        return count;


    }

    private void numTeamsUp(int[] rating, int i, int c, int min) {
        if (i > rating.length) {
            return;
        }
        if (c == 3) {
            count++;
        } else {
            for (int j = i; j < rating.length; j++) {
                if (min < rating[j]) {
                    numTeamsUp(rating, j + 1, c + 1, rating[j]);
                }
            }
        }


    }

    private void numTeamsDown(int[] rating, int i, int c, int max) {
        if (i > rating.length) {
            return;
        }
        if (c == 3) {
            count++;
        } else {
            for (int j = i; j < rating.length; j++) {
                if (max > rating[j]) {
                    numTeamsDown(rating, j + 1, c + 1, rating[j]);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int i = new n02().numTeams(a);
        System.out.println(i);
    }
}
