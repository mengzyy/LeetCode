package com.mzy.leetcode.compest667;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-19 10:50
 **/
public class Main2 {
    public List<List<String>> displayTable(List<List<String>> orders) {

        List<String> foodName = new ArrayList<>();
        for (List<String> order : orders) {
            String name = order.get(2);
            if (!foodName.contains(name)) {
                foodName.add(name);
            }
        }
        //食物排序
        Collections.sort(foodName);
        //使用hashmap存储食物对应索引
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < foodName.size(); i++) {
            hashMap.put(foodName.get(i), i);
        }
        //定义结果数组
        List<Integer> hasFoot = new ArrayList<>();
        int[][] book = new int[501][foodName.size()];
        for (List<String> order : orders) {
            int tableNum = Integer.parseInt(order.get(1));
            int footIndex = hashMap.get(order.get(2));
            book[tableNum][footIndex]++;
            if (!hasFoot.contains(tableNum)) {
                hasFoot.add(tableNum);
            }
        }

        List<List<String>> res = new ArrayList<>();
        List<String> firstCow = new ArrayList<>();
        firstCow.add("Table");
        for (String s : foodName) {
            firstCow.add(s);
        }
        res.add(firstCow);
        Collections.sort(hasFoot);
        for (Integer integer : hasFoot) {
            List<String> temp = new ArrayList<>();
            int[] ints = book[integer];
            temp.add(String.valueOf(integer));
            for (int anInt : ints) {
                temp.add(String.valueOf(anInt));
            }
            res.add(temp);
        }
        return res;


    }

    public static void main(String[] args) {


    }

}
