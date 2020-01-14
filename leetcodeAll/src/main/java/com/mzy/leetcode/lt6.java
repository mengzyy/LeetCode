package com.mzy.leetcode;

//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//L   C   I   R
//E T O E S I I G
//E   D   H   N
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
//请你实现这个将字符串进行指定行数变换的函数：
//
//string convert(string s, int numRows);
//示例 1:
//
//输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//示例 2:
//
//输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/zigzag-conversion
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class lt6 {


    public static String convert(String s, int numRows) {
        if (s.length() < numRows || s.length() < 2 || numRows < 2) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        //首先需要判断多少个字母为一个循环
        int rol = numRows + numRows - 2;
        //计算多少个循环
        int cor = s.length() / rol;
        int rel = s.length() % rol;
        if (rel != 0) {
            cor += 1;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cor; j++) {
                //上下两行
                if (j * rol + i < s.length()) {
                    res.append(s.charAt(j * rol + i));
                }
                //中间
                int midindex = j * rol + i + rol - 2 * i;
                if (i != 0 && i != numRows - 1 && midindex < s.length() && midindex > 0) {
                    res.append(s.charAt(j * rol + i + rol - 2 * i));
                }
            }

        }

        return res.toString();


    }

    public static void main(String[] args) {

        System.out.println(convert("LEETCODEISHIRING", 4));

    }


}