package com.lm.algorithm.middle.treeAndgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-10 19:25
 * @Description:给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty())
            {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
