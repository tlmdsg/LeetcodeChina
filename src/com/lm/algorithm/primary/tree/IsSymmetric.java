package com.lm.algorithm.primary.tree;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 17:22
 * @Description:给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 != null && t2 != null && t1.val == t2.val) {
            return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
