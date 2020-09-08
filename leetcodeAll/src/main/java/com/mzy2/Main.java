package com.mzy2;


//*
//定义一个int类型变量接收一个大于100的三位数,求出100到该数字之间满足如下要求的数字之和:
//
//        1.数字的个位数不为7;
//
//        2.数字的十位数不为5;
//
//        3.数字的百位数不为3;
//
//        请采用你熟悉的编程语言完成

import java.util.Scanner;

class ada {

    public void ada() {
        System.out.println("sd");
    }

}

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    如果输入参数不满足题干要求，请返回-1
    ******************************开始写代码******************************/
    static int calSum(int number) {
        if (number > 999) number = 999;
        int ans = 0;
        for (int i = 100; i < number; i++) {
//            String num = String.valueOf(i);
            if (i / 100 == 3) continue;
            if ((i - 100 * (i / 100)) / 10 == 5) continue;
            if (i % 10 == 7) continue;
//            if (isValid(num)) ans += i;
            ans += i;

        }
        return ans;


    }

    private static boolean isValid(String num) {
        if (num.charAt(2) == '7') return false;
        if (num.charAt(1) == '5') return false;
        if (num.charAt(0) == '3') return false;
        return true;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        while (true) {
            int _number;
            _number = Integer.parseInt(in.nextLine().trim());

            res = calSum(_number);
            System.out.println(String.valueOf(res));
        }
    }
}
