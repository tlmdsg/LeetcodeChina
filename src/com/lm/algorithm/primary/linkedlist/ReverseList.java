package com.lm.algorithm.primary.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 15:45
 * @Description:反转一个单链表。 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }

}
