package com.mzy.offer;

import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 17:02
 **/
public class jghfd {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        //头节点入队
        queue.offer(pRoot);
        boolean flag = false;
        while (queue.size() != 0) {
            //队列全部出队
            ArrayList<Integer> temp = new ArrayList<>();
            while (queue.size() != 0) {
                TreeNode out = queue.poll();
                stack.push(out);
                temp.add(out.val);

            }
            res.add(temp);
            //栈全部出栈
            while (stack.size() != 0) {
                TreeNode out = stack.pop();
                if (!flag) {
                    if (out.right != null) queue.offer(out.right);
                    if (out.left != null) queue.offer(out.left);

                } else {
                    if (out.left != null) queue.offer(out.left);
                    if (out.right != null) queue.offer(out.right);

                }

            }
            flag=!flag;


        }
        return res;
    }

    public static void main(String[] args) {


    }

}
