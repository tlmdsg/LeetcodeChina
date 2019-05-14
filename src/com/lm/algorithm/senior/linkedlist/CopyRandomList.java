package com.lm.algorithm.senior.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-21 13:18
 * @Description: 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 *
 * 示例：
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *
 * 提示：
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 */

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
};

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head, next, copyCur, copyHead;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val, next, null);
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        copyHead = head.next;
        cur = head;
        while (cur != null) {
            copyCur = cur.next;
            cur.next = copyCur.next;
            if (cur.next != null)
                copyCur.next = cur.next.next;
            cur = cur.next;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        System.out.println(copyRandomList.copyRandomList(new Node(-1, null, null)));
    }

}
