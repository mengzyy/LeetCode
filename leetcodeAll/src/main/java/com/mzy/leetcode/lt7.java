package com.mzy.leetcode;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

public class lt7 {

    public static int reverse(int x) {

        boolean sc = true;
        if (x < 0) sc = false;
        x = Math.abs(x);
        StringBuilder res = new StringBuilder();
        String xStr = String.valueOf(x);
        for (int i = xStr.toCharArray().length - 1; i >= 0; i--) {
            res.append(xStr.charAt(i));

        }
        int resInt = 0;
        try {
            resInt = Integer.parseInt(res.toString());
            if (!sc) resInt *= -1;
        } catch (Exception e) {
            resInt = 0;
        }


        return resInt;

    }

    //使用 / %实现类似的堆栈反转
    public static int reverse2(int x) {

        int rev = 0;
        int pop = 0;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;


            rev = rev * 10 + pop;



        }

        return rev;


    }


    public static void main(String[] args) {

        System.out.println(reverse2(-123));


    }
}
