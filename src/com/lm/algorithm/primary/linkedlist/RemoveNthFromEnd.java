package com.lm.algorithm.primary.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 15:34
 * @Description:给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 */

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode first = head, second = head, pre = null;
        for (int i = 0; i < n; i++)
            first = first.next;
        while (first != null) {
            first = first.next;
            pre = second;
            second = second.next;
        }
        if (pre != null) {
            pre.next = second.next;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
