package com.mzy.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-01 13:19
 **/
public class lt113 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return null;
        res = new ArrayList<>();
        List<Integer> r = new ArrayList<Integer>();
        r.add(root.val);
//        dfs(root, r, root.val, sum);
        stackMethod(root, sum);
        return res;
    }

    private void stackMethod(TreeNode root, int sum) {

//        if not root: return []
//        stack = [([root.val], root)]
//        res = []
//        while stack:
//        tmp, node = stack.pop()
//        if not node.right and not node.left and sum(tmp) == sum_:
//        res.append(tmp)
//        if node.right:
//        stack.append((tmp + [node.right.val], node.right))
//        if node.left:
//        stack.append((tmp + [node.left.val], node.left))

        Stack<TreeNode> stack = new Stack<>();
        //根节点入栈
        stack.push(root);
        while (stack.size() != 0) {
            //左子树入栈
            TreeNode pop = stack.pop();
            //右子树入栈
            if (pop.right != null) stack.push(pop.right);
            //有子树入栈
            if (pop.left != null) stack.push(pop.left);
        }


    }

    private void dfs(TreeNode root, List<Integer> arrayList, int sum, int tartget) {

        if (root.left == null && root.right == null && sum == tartget) {
            List<Integer> temp = new ArrayList<>();
            for (Integer integer : arrayList) {
                temp.add(integer);
            }
            res.add(temp);
        } else {

            if (root.left != null) {
                arrayList.add(root.left.val);
                dfs(root.left, arrayList, sum + root.left.val, tartget);
                arrayList.remove(arrayList.size() - 1);
            }

            if (root.right != null) {
                arrayList.add(root.right.val);
                dfs(root.right, arrayList, sum + root.right.val, tartget);
                arrayList.remove(arrayList.size() - 1);
            }


        }
    }
}
