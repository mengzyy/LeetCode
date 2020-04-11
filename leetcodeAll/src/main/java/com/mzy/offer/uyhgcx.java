package com.mzy.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 15:59
 **/

/*
输入一个递增排序的数组和一个数字S，
在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class uyhgcx {
    public  ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length <= 1) return res;

        int max = Integer.MAX_VALUE;


        //定义双指针
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int tempsum = array[low] + array[high];
            if (tempsum == sum) {
                if (max > array[low] * array[high]) {
                    max = array[low] * array[high];
                    if (res.size() == 0) {
                        res.add(array[low]);
                        res.add(array[high]);
                    } else {

                        res.remove(1);
                        res.remove(0);
                        res.add(array[low]);
                        res.add(array[high]);
                    }
                }
                low++;
                high--;


            } else if (tempsum > sum) {
                high--;
            } else {
                low++;
            }


        }
        return res;


    }

    public static void main(String[] args) {


//      int[] arr = {1,2,4,7,11,15};
//        FindNumbersWithSum(arr,15);
    }


}
