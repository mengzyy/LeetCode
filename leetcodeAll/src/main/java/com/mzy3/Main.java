package com.mzy3;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-25 14:57
 **/
public class Main {
    private Stack<Integer> a;// 输入栈
    private Stack<Integer> b;// 输出栈

    public Main() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public static void main(String[] args) {

        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        List<String> cz = new ArrayList<>();
        while (scanner.hasNext()) {
            int len = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < len; i++) {
                cz.add(scanner.nextLine());
            }

            for (String s : cz) {
                if (s.equals("poll")) {
                    main.pop();
                } else if (s.equals("peek")) {
                    System.out.println(main.peek());
                } else {
                    String[] s1 = s.split(" ");
                    main.push(Integer.parseInt(s1[1]));
                }

            }

        }


    }

}
