package com.mzy.leetcode.compest184;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-12 10:20
 **/
public class n01 {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String one = words[i];
                String two = words[j];
                if (one.length() != two.length()) {
                    if (two.contains(one)) {
                        res.add(one);
                        break;
                    }
                }


            }

        }
        return res;


    }


    public static void main(String[] args) {

        String[] wo = {"mass", "as", "hero", "superhero"};

        List<String> list = new n01().stringMatching(wo);
        System.out.println(list);
    }


}
