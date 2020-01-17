package com.mzy.leetcode;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"
//示例 2:
//
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//说明:
//
//所有输入只包含小写字母 a-z 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-common-prefix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class lt14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].equals("")) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 0; i < prefix.toCharArray().length; i++) {
            char temp = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length()<i+1 || strs[j].charAt(i)!=temp){
                    return prefix.substring(0,i);
                }

            }

        }
        return prefix;


    }


    //使用减法的思路 ，不要太巧妙
    //
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //垂直扫描
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"leet", "le", "l"}));


    }
}
