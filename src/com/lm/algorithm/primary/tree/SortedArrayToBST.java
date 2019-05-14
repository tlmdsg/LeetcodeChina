package com.lm.algorithm.primary.tree;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 19:06
 * @Description:将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

public class SortedArrayToBST {

    //效率高
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, start, mid - 1);
        root.right = help(nums, mid + 1, end);
        return root;
    }

    //效率低
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int length = nums.length;
        if (length == 1) {
            return new TreeNode(nums[0]);
        }
        int pivot = length / 2;
        TreeNode root = new TreeNode(nums[pivot]);
        root.left = sortedArrayToBST2(Arrays.copyOfRange(nums, 0, pivot));
        root.right = sortedArrayToBST2(Arrays.copyOfRange(nums, pivot + 1, length));
        return root;
    }


    public static void main(String[] args) {

    }

}
