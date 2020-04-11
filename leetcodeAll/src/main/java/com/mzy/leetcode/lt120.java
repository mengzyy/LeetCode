package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-01 14:10
 **/
public class lt120 {

    //自顶向下
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        for (int i = triangle.size() - 2; i >= 0; i--) {
            //下面一层
            List<Integer> upList = triangle.get(i + 1);
            //当前层
            List<Integer> nowList = triangle.get(i);

            for (int j = 0; j <= nowList.size() - 1; j++) {
                int upLeft = upList.get(j);
                int upRight = upList.get(j + 1);
                int cur = nowList.get(j);
                nowList.set(j, Math.min(upLeft + cur, upRight + cur));
            }
        }
        return triangle.get(0).get(0);


    }

    public static void main(String[] args) {
        List<List<Integer>> triangle= new ArrayList<>();

        List<Integer> temp1 = new ArrayList<>();
        temp1.add(2);
        triangle.add(temp1);

        List<Integer> temp2 = new ArrayList<>();
        temp2.add(3);
        temp2.add(4);
        triangle.add(temp2);

        List<Integer> temp3 = new ArrayList<>();
        temp3.add(6);
        temp3.add(5);
        temp3.add(7);
        triangle.add(temp3);

        List<Integer> temp4 = new ArrayList<>();
        temp4.add(4);
        temp4.add(1);
        temp4.add(8);
        temp4.add(3);
        triangle.add(temp4);



        minimumTotal(triangle);




    }


}
