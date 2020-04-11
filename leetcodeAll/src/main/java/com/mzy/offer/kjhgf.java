package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 10:45
 **/

/*

统计一个数字在排序数组中出现的次数。
 */

/*
1.找到相等的时候
2.标志位为false
3.迭代


 */
public class kjhgf {

    public static int GetNumberOfK(int[] array, int k) {

        int lastK = getLastK(array, k, 0, array.length);
        return lastK;


    }

    //循环写法
    private static int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 < length && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3;
        System.out.println(GetNumberOfK(array, k));
    }

}
