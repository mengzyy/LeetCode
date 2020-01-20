package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lt17 {

    static List<String> outputlist = null;

    public List<String> letterCombinations(String digits) {

        outputlist = new ArrayList<>();
        if (digits.length() == 0) return outputlist;
        Map<Character, String> map = new HashMap<>();

        //添加
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> inputlist = new ArrayList<>();
        for (int i = 0; i < digits.toCharArray().length; i++) {
            inputlist.add(map.get(digits.charAt(i)));

        }

        letterCombinations2(inputlist, 0, "");

        return outputlist;


    }

    public void letterCombinations2(List<String> inputlist, int index, String temp) {

        if (index == inputlist.size()) {
            outputlist.add(temp);
            return;


        }

        for (int j = 0; j < inputlist.get(index).toCharArray().length; j++) {
            letterCombinations2(inputlist, index + 1, temp + inputlist.get(index).charAt(j));

        }


    }

    public static void main(String[] args) {

        lt17 lt = new lt17();
        List<String> res = lt.letterCombinations("245");
        for (String re : res) {
            System.out.println(re);

        }


    }


}
