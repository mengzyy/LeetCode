package com.mzy.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-03-21 17:38
 **/
public class fhg {
    int index = -1;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));

        return sb.toString();

    }

    TreeNode Deserialize(String str) {
        index++;
//        if (index >= str.length()) return null;
        String[] split = str.split(",");

        if (!split[index].equals("#")) {
            TreeNode treeNode = new TreeNode(Integer.valueOf(split[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);

            return treeNode;
        } else {
            return null;
        }


    }
}
