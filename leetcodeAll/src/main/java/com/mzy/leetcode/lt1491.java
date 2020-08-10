package com.mzy.leetcode;

import java.util.Map;

/**
 * @description:
 * @author: Meng ZhongYi
 * @create: 2020-08-07 10:42
 **/
public class lt1491 {
    public double average(int[] salary) {
        if (salary.length == 2) return (double) (salary[0] + salary[1]) / 2;
        int maxSalary = Integer.MIN_VALUE;
        int minSalary = Integer.MAX_VALUE;
        double sum = 0;
        for (int s : salary) {
            maxSalary = Math.max(maxSalary, s);
            minSalary = Math.min(minSalary, s);
            sum += s;
        }
        return (sum-maxSalary-minSalary) / (salary.length - 2);

    }
}
