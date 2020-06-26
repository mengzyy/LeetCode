package com.mzy.leetcode;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-06-08 09:04
 **/
public class lt990 {
    class unionSet {
        public int[] parent;

        public unionSet() {
            this.parent = new int[26];
            for (int i = 0; i < parent.length; i++) {
                //初始化时，将每个节点根节点指向自己
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            parent[x] = find(y);
        }

        public boolean isCounneted(int x, int y) {
            return find(x) == find(y);
        }

    }


    public boolean equationsPossible(String[] equations) {
        unionSet unionSet = new unionSet();
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '=') {
                int leftchar = chars[0] - 'a';
                int rightchar = chars[3] - 'a';
                unionSet.union(leftchar, rightchar);
            }
        }
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '!') {
                int leftchar = chars[0] - 'a';
                int rightchar = chars[3] - 'a';
                if (unionSet.isCounneted(leftchar, rightchar)) return false;
            }
        }
        return true;


    }


}
