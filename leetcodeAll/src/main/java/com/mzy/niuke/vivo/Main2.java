package com.mzy.niuke.vivo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-02 17:21
 **/
public class Main2 {
    public static int solution(int n) {

        //首先需要找到因数
        boolean hasYin = false;
        //存放全部的因子
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        while (true) {
            int curNum = n / 2;
            for (int i = 2; i <= curNum; i++) {
                if (i > 9) return -1;
                if (n % i == 0) {
                    list.add(i);
                    hasYin = true;
                    n /= i;
                    break;
                }
            }
            //没有再多的因子
            if (!hasYin) {
                if(n>9)return -1;
                list.add(n);
                break;
            } else {
                hasYin = false;
            }
        }

        //从后向前遍历
        int tempMul = 1;
        while (list.size() != 0) {
            Integer remove = list.remove(list.size() - 1);
            if (tempMul * remove < 10) {
                tempMul *= remove;
            } else {
                res.add(tempMul);
                tempMul = remove;
            }
        }
        res.add(tempMul);
        //排序
        Collections.sort(res);
        int res2 = 0;
        for (Integer re : res) {
            res2 = res2 * 10 + re;
        }

        return res2;

    }

    public static void main(String[] args) {

        System.out.println(solution(123456789));

    }
}
