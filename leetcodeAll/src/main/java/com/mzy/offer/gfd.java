package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-18 12:37
 **/
public class gfd {
    public static int NumberOf1Between1AndN_Solution(int n) {

        int count = String.valueOf(n).length();
        if (count < 2) return n >= 1 ? 1 : 0;
        int countpre = 1;

        for (int i = 0; i < count - 2; i++) {

            countpre = (int) Math.pow(10, i + 2) + 8 * countpre;
        }
        int countpro = n / (int) Math.pow(10, count - 1);
        if (countpro != 1) {
            countpre += countpre * (countpro - 1);
        }
        //添加1为首的
        countpre += n % ((int) Math.pow(10, count - 1));
        return countpre;


    }

    public static void main(String[] args) {


        System.out.println(NumberOf1Between1AndN_Solution(100));

    }
}
