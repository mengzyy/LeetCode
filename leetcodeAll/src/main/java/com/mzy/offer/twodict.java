package com.mzy.offer;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-02-29 21:57
 **/


/*
题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


 */
public class twodict {


    public boolean Find(int target, int[][] array) {

        if (array.length == 0) return false;

        int i = array.length-1;
        int j = 0;
        while (i >= 0 && j <= array[0].length-1) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }


        return false;


    }


}
