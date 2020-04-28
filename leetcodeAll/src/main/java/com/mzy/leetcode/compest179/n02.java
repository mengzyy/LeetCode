package com.mzy.leetcode.compest179;

import java.beans.Transient;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-18 10:41
 **/
public class n02 {
    public static int numTimesAllBlue(int[] light) {
        if (light == null || light.length == 0) return -1;
        //存储复合状态，0代表关灯，2代表亮着，3代表蓝灯
        int res = 0;
        int[] book = new int[light.length + 1];
        for (int i : light) {
            if (i == 1) book[i] = 3;
            else {
                int left = book[i - 1];
                if (left == 0 || left == 2) {
                    book[i] = 2;
                } else {
                    book[i] = 3;
                }
            }
            if (book[i] == 3) {
                //向左遍历全为蓝
                int right = i + 1;
                if (right <= light.length && book[right] == 2) {
                    while (right <= light.length&&book[right] == 2) {
                        book[right] = 3;
                        right++;
                    }

                }

            }
            boolean isBlue = true;
            for (int j = 1; j < book.length; j++) {
                if (book[j] == 2) {
                    isBlue = false;
                    break;
                }

            }
            res += isBlue ? 1 : 0;

        }
        return res;


    }

    public static void main(String[] args) {


        int i = numTimesAllBlue(new int[]{2, 1, 3, 5, 4});
        System.out.println(i);
    }
}
