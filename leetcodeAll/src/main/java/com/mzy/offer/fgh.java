package com.mzy.offer;

import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-19 16:44
 **/
/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

/*
1.使用栈的方式
2.最后稍作处理
 */
public class fgh {
    public static String ReverseSentence(String str) {
        if (str.length() <= 1) return str;


        Stack<String> stack = new Stack<>();
        for (String s : str.split(" ")) {
            stack.push(s);
        }

        StringBuilder res = new StringBuilder();
        while (stack.size() != 0) {
            String pop = stack.pop();
            if (stack.size() == 0 && !pop.equals(" ")) {
                res.append(pop);
            } else {
                res.append(pop + " ");
            }
        }

        return res.toString();

    }

    public static void main(String[] args) {


        System.out.println(ReverseSentence(" A"));
    }

}
