package com.mzy.leetcode.compest503;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-03 10:31
 **/
public class Main {
    public String destCity(List<List<String>> paths) {


        HashMap<String, String> maps = new LinkedHashMap<>();
        for (List<String> path : paths) {
            String sources = path.get(0);
            String end = path.get(1);
            maps.put(sources, end);

        }

        for (List<String> path : paths) {
            String end = path.get(1);
            if (!maps.containsKey(end)) {
                return end;
            }
        }
        return null;


    }


}
