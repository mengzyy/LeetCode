package com.mzy.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-23 10:10
 **/
public class dtggdgt {


    public static String xuanlv(List<String> a) {
        //对a排序
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) > o2.charAt(0)) {
                    return 1;
                } else if (o1.charAt(0) < o2.charAt(0)) {
                    return -1;
                }
                return 0;
            }
        });

        String res = a.get(0);
        int start = a.get(0).charAt(0);
        int end = a.get(0).charAt(a.get(0).length() - 1);
        for (int i = 1; i < a.size(); i++) {
            String temp = a.get(i);
            int temps = a.get(i).charAt(0);
            int tempe = a.get(i).charAt(temp.length() - 1);

            if (end <=temps) {
                //如果小于，直接合并
                res += temp;
                start = temps;
                end = tempe;
            } else if(end>temps){
                //重叠合并
                res = hbing(res, temp);
                end = tempe;
            }

        }

        return res;


    }



    private static String hbing(String res, String temp) {

        for (int i = 0; i < res.toCharArray().length; i++) {
            if (res.charAt(i) == temp.charAt(0)) {
                if (i == 0) return temp;
                else {
                    return res.substring(0, i) + temp;
                }
            }

        }
        return null;

    }


    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("aaabbbb");
        input.add("bcd");
        input.add("cdef");
        input.add("zz");

        String xuanlv = xuanlv(input);
        System.out.println(xuanlv);


    }


}





