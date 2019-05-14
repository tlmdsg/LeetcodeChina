package com.lm.algorithm.middle.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-17 10:04
 * @Description:序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        StringBuilder sb = new StringBuilder();
        TreeNode cur;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append(',');
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left == null)
                sb.append('#').append(',');
            else {
                sb.append(cur.left.val).append(',');
                queue.add(cur.left);
            }
            if (cur.right == null)
                sb.append('#').append(',');
            else {
                sb.append(cur.right.val).append(',');
                queue.add(cur.right);
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("#"))
            return null;
        String[] ns = data.split(",");
        TreeNode[] nodes = new TreeNode[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nodes[i] = ns[i].equals("#") ? null : new TreeNode(Integer.valueOf(ns[i]));
        }
        Queue<TreeNode> level = new LinkedList<>();
        level.add(nodes[0]);
        TreeNode cur;
        int i = 1;
        while (!level.isEmpty()) {
            int length = level.size();
            for (int j = 0; j < length; j++) {
                cur = level.poll();
                if (nodes[i] != null)
                    level.add(nodes[i]);
                cur.left = nodes[i++];
                if (nodes[i] != null)
                    level.add(nodes[i]);
                cur.right = nodes[i++];
            }
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String str = codec.serialize(root);
        root = codec.deserialize(str);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.right);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right.val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
