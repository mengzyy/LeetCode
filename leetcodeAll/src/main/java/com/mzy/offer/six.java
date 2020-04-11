package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-01 15:11
 **/
public class six {


    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int temp = array[0];
        for (int i : array) {
            if (temp > i) {
                return i;
            } else {
                temp = i;
            }
        }
        return array[0];

    }

    //使用二分的方法
    public int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int temp = array[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] >= temp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return array[left];

    }


}
