package com.mzy.leetcode;

public class lt38 {

    public static  String countAndSay(int n) {


        String input = String.valueOf(1);

        for (int i = 0; i < n; i++) {
            String loopstr = input;
            StringBuilder res = new StringBuilder();
            String ctemp = "a";
            for (char c : loopstr.toCharArray()) {
                //如果不等于
                if (c != ctemp.charAt(0)) {
                    if (ctemp.charAt(0) != 'a') {
                        //将ctemp的值加入
                        res.append(ctemp.length());
                        res.append(ctemp.charAt(0));
                    }
                    ctemp=String.valueOf(c);

                    //如果等
                } else {
                    //高兴ctemp的值
                    ctemp += String.valueOf(c);
                }
            }
            //将ctemp值加入
            if (!ctemp.equals("")) {
                //将ctemp的值加入
                res.append(ctemp.length());
                res.append(ctemp.charAt(0));
            }
            input = res.toString();


        }
        return input;


    }

    public static void main(String[] args) {

        System.out.println(countAndSay(11));
    }

}
