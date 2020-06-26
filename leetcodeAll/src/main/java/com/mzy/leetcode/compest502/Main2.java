package com.mzy.leetcode.compest502;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 22:35
 **/
public class Main2 {
    public int maxDiff(int num) {

        String numStr = String.valueOf(num);
        int n = numStr.length();
        String sb = numStr;
        String sb2 = numStr;
        for (int i = 0; i < n; i++) {
            if (numStr.charAt(i) != '9') {
                sb = numStr.replace(numStr.charAt(i), '9');
                break;
            }
        }
        char c = numStr.charAt(0);
        if (c == '1') {
            for (int i = 1; i < n; i++) {
                if (numStr.charAt(i) != '0'&&numStr.charAt(i)!='1') {
                    sb2 = numStr.replace(numStr.charAt(i), '0');
                    break;
                }
            }
            sb2="1"+sb2.substring(1);

        } else {
            sb2 = numStr.replace(c, '1');
        }
        return Integer.parseInt(sb) - Integer.parseInt(sb2);


    }

    public static void main(String[] args) {

        System.out.println(new Main2().maxDiff(1101057));

    }
}
