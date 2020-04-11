package com.mzy.niuke.vivo;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-02 16:03
 **/
public class Main {

    public static int solution(int n) {


        int sum = 0;
        int adayCount = 1;
        int day = 1;
        while (day <= n) {
            sum += adayCount * adayCount;
            adayCount++;
            day += adayCount;

        }
        day -= adayCount;
        sum += adayCount * (n - day);


        return sum;
    }

    public static void main(String[] args) {


        System.out.println(solution(3));
    }
}
