package com.mzy.offer;

import java.util.ArrayList;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 15:11
 **/

/*
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class fghfgdf {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 2) return res;

        //定义双指针
        int low = 1;
        int high = 2;
        while (low < high) {
            int sumtemp = (high + low) * (high - low + 1) / 2;
            if (sumtemp == sum) {

                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    temp.add(i);
                }
                res.add(temp);
                low++;

            } else if (sumtemp > sum) {
                low++;
            } else {
                high++;
            }


        }
        return res;


    }


}
