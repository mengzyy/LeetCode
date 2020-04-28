package com.mzy.leetcode.compest426;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-26 10:36
 **/
public class Main2 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] leftDp = new int[len + 2];
        int[] rightDp = new int[len + 2];
        leftDp[0] = 0;
        rightDp[len + 1] = 0;
        for (int i = 1; i <= k; i++) {
            leftDp[i] = leftDp[i - 1] + cardPoints[i - 1];
            rightDp[len-i+1] = rightDp[len-i+2] + cardPoints[len - i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <=k; i++) {
            max = Math.max(leftDp[i] + rightDp[len - (k - i)+1], max);
        }
        return max;
    }

    public static void main(String[] args) {

        new Main2().maxScore(new int[]{1,2,3,4,5,6,1},3);

    }

}
