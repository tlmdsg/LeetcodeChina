package com.lm.algorithm.primary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 18:48
 * @Description:给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        tmp.add(root);
        int count = 1;
        TreeNode cur = root;
        while (!tmp.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int n = count;
            count = 0;
            for (int i = 0; i < n; i++) {
                cur = tmp.remove();
                level.add(cur.val);
                if (cur.left != null) {
                    tmp.add(cur.left);
                    count++;
                }
                if (cur.right != null) {
                    tmp.add(cur.right);
                    count++;
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
