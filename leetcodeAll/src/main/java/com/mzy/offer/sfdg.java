package com.mzy.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 17:31
 **/
public class sfdg {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        //头节点入队
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(pRoot);
        while (queue.size() != 0) {
            //队列全部出队
            ArrayList<Integer> temp = new ArrayList<>();
            while (queue.size() != 0) {
                TreeNode out = queue.poll();
                if (out.left != null) queue2.add(out.left);
                if (out.right != null) queue2.add(out.right);
                temp.add(out.val);

            }
            res.add(temp);

            while (queue2.size() != 0) {
                queue.add(queue2.poll());
            }


        }
        return res;

    }
}
