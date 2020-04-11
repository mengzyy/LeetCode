package com.mzy.leetcode.compest329;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-29 10:31
 **/
public class n01 {

    public  int findLucky(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] book = new int[501];

        for (int i : arr) {
            book[i] += 1;

        }
        //遍历book
        for (int i = book.length - 1; i >= 1; i--) {
            if (book[i] == i) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

//        int[] arr = {7};
//        System.out.println(findLucky(arr));

    }
}
