package com.mzy.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-14 20:28
 **/
public class n24 {

    //n2的方法
    public static int f(String input) {
        int res = 0;
        if (input.length() <= 1) return res;
        int n = input.length();
        for (int i = 1; i < n; i++) {

            //以偶数中心展开
            int low = i - 1;
            int high = i;
            while (low >= 0 && high < n && input.charAt(low) == input.charAt(high)) {
                low--;
                high++;
            }
            res = res < high - low - 1 ? high - low - 1 : res;


            //以奇数展开
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < n && input.charAt(low) == input.charAt(high)) {
                low--;
                high++;
            }
            res = res < high - low - 1 ? high - low - 1 : res;

        }
        return res;

    }

    //manacher算法
    public static int f2(String input) {
        List<Character> containList = new ArrayList<>();
        containList.add('#');
        for (int i = 0; i < input.length(); i++) {
            containList.add(input.charAt(i));
            containList.add('#');
        }
        int n = containList.size();
        //边界
        int max = 0;
        //最大边界所在中心
        int p0 = 0;
        //res
        int res = Integer.MIN_VALUE;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            //赋予初始值
            dp[i] = 1;
            if (i < max) {

                dp[i] = Math.min(max - i + 1, dp[2 * p0 - i]);
            }
            //两边扩展
            while (i - dp[i] >= 0 && i + dp[i] < n && containList.get(i + dp[i]) == containList.get(i - dp[i])) {
                dp[i]++;
            }

            //更新max po res
            if (dp[i] + i - 1 > max) {
                max = dp[i] + i - 1;
                p0 = i;
            }
            res = Math.max(res, dp[i]);
        }
        return res - 1;


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            System.out.println(f2(sc.next()));
        }
    }
}
