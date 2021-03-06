package com.mzy.leetcode;

import java.util.*;

public class lt39 {
    public static List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return null;
        // i控制向前 ， temp控制中间值
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        turn(candidates, target, temp, 0);
//        Set set = new HashSet();
//        set.addAll(res);
//        List<List<Integer>>  r = new ArrayList<>();
//        r.addAll(set);
        return  res;
    }
    private void turn(int[] candidates, int target, List<Integer> temp, int i) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int j = i; j < candidates.length; j++) {

            if(target-candidates[j]>=0 && temp.indexOf(candidates[j])==-1){
                temp.add(candidates[j]);
                turn(candidates, target - candidates[j], temp, j+1);
                temp.remove(temp.size() - 1);}

        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        lt39 lt = new lt39();
        lt.combinationSum(candidates, target);
        for (List<Integer> re : res) {

            System.out.println(re);


        }


    }


}
