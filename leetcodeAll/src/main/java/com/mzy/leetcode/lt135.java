package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-20 11:08
 **/
public class lt135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return -1;

        int n = ratings.length;
        int[] book = new int[n];
        for (int i = 0; i < n; i++) {
            book[i]++;
        }

        for (int i = 0; i < n; i++) {
            //向左看
            if (i - 1 >= 0 && ratings[i] > ratings[i - 1]) {
                if (book[i] <= book[i - 1]) {
                    int temp = book[i - 1] - book[i] + 1;
                    book[i] += temp;
                }
            }
            //向右看
            if (i + 1 <= n - 1 && ratings[i] > ratings[i + 1]) {
                if (book[i] <= book[i + 1]) {
                    int temp = book[i + 1] - book[i] + 1;
                    book[i] += temp;
                }
                //向右看会产生问题
                for (int j = i - 1; j >= 0; j--) {
                    if (ratings[j] > ratings[j + 1]) {
                        if (book[j] <= book[j + 1]) {
                            int temp = book[j+ 1] - book[j] + 1;
                            book[j] += temp;

                        } else {
                            //右边不满足直接退出
                            break;
                        }
                    }

                }
            }

        }
        int res = 0;
        for (int i : book) {
            res += i;

        }
        return res;

    }


    public static void main(String[] args) {


    }
}
