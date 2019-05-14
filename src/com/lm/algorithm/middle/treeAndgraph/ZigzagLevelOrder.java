package com.lm.algorithm.middle.treeAndgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-10 19:34
 * @Description:给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean flag = true;
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            LinkedList<Integer> level = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode cur = list.removeFirst();
                if (flag)
                    level.addLast(cur.val);
                else
                    level.addFirst(cur.val);
                if (cur.left != null) list.add(cur.left);
                if (cur.right != null) list.add(cur.right);
            }
            result.add(level);
            flag = !flag;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
