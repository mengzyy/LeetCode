package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 13:12
 **/

/*

一个整型数组里除了两个数字之外，其他的数字都出现了两次。
请写程序找出这两个只出现一次的数字。
 */

/*
1.得到异或的结果
2.分离两个数组
3.异或出结果
 */
public class gbvcx {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array.length <= 1) return;
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        } ;


        //得到异或的结果
        int yhres = array[0];
        for (int i = 1; i < array.length; i++) {
            yhres ^= array[i];
        }

        int index = 0;
        while ((yhres & 1) == 0) {
            yhres = yhres >> 1;
            index++;
        }

        //初始化
        num1[0] = 0;
        num2[0] = 0;

        //分离
        for (int i : array) {
            int i1 = i >> index;
            if ((i1 & 1) == 0) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }

        }


    }
}
