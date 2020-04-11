package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 22:15
 **/
public class tgrffd {

    //n为一个数组
    //m要mod当前数组真正的长度
    //count计算当前的喊话进度
    //使用标记数组来标记小朋友是否出局
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 0 || m <= 0) return -1;


        int[] book = new int[n];

        int count = 0;
        int reallen = n;
        int k = m - 1 % reallen;
        for (int i = 0; i < n; i++) {
            if (book[i] == 0) {
                if (count == k) {
                    //出局,数组长度减一
                    book[i] = 1;
                    reallen--;
                    if (reallen == 1) {
                        //寻找为0的唯一值
                        for (int j = 0; j < book.length; j++) {
                            if (book[j] == 0) return j;

                        }
                        return -1;
                    }
                    //计算器为0，k重新计算
                    count = 0;
                    k = m - 1 % reallen;
                } else {
                    count++;
                }
            }
            if (i == n - 1) i = -1;


        }
        return -1;


    }

    public static void main(String[] args) {
        int i = LastRemaining_Solution(6, 4);
        System.out.println(i);


    }
}
