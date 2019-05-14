package com.lm.algorithm.middle.treeAndgraph;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-10 19:46
 * @Description:根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (preorder[0] == inorder[i])
                break;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
        return root;
    }

    public static void main(String[] args) {

    }

}
