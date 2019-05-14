package com.lm.algorithm.middle.treeAndgraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-13 10:33
 * @Description:给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Connect {


    //递归解题
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node curLeft, curRight;
        if (root.left != null) {
            Node left = connect(root.left);
            Node right = connect(root.right);
            curLeft = left;
            curRight = right;
            while (curLeft != null) {
                curLeft.next = curRight;
                curLeft = curLeft.right;
                curRight = curRight.left;
            }
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null)
            return null;
        Node cur = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(cur);
        int count = 0, n = 1;
        while (!queue.isEmpty()) {
            if (n >= 1) {
                cur = queue.remove();
                if (n > 1)
                    cur.next = ((LinkedList<Node>) queue).getFirst();
                n--;
                if (cur.left != null) {
                    queue.add(cur.left);
                    count++;
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    count++;
                }
            } else {
                n = count;
                count = 0;
            }
        }
        return root;
    }


    public static void main(String[] args) {

    }

}
