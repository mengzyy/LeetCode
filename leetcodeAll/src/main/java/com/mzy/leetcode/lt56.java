package com.mzy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lt56 {
    //定义数据格式
    class areaNode {
        int start;
        int end;

        public areaNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    //比较器
    class areaNodecompare implements Comparator<areaNode> {
        @Override
        public int compare(areaNode a, areaNode b) {
            if (a.start == b.start) return 0;
            else {
                return a.start > b.start ? 1 : -1;

            }
        }
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        //将输入变成自定义集合
        List<areaNode> areaNodeList = new ArrayList<>();

        for (int[] interval : intervals) {
            areaNodeList.add(new areaNode(interval[0], interval[1]));
        }
        //排序
        Collections.sort(areaNodeList, new areaNodecompare());

        //输出
        List<areaNode> mergelist = new ArrayList<>();
        mergelist.add(areaNodeList.get(0));
        for (areaNode areaNode : areaNodeList) {
            if (mergelist.get(mergelist.size() - 1).end >= areaNode.start) {
                areaNode temp = mergelist.get(mergelist.size() - 1);
                temp.start = temp.start <= areaNode.start ? temp.start : areaNode.start;
                temp.end = temp.end >= areaNode.end ? temp.end : areaNode.end;
            } else {
                mergelist.add(areaNode);
            }
        }
        //格式
        int[][] res = new int[mergelist.size()][2];
        for (int i = 0; i < mergelist.size(); i++) {
            res[i] = new int[]{mergelist.get(i).start, mergelist.get(i).end};
        }

        return res;


    }


    public static void main(String[] args) {


    }
}
