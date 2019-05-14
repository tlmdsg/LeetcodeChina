package com.lm.algorithm.primary.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 15:49
 * @Description:将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head, cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            cur.next = cur2;
        }
        if (cur2 == null) {
            cur.next = cur1;
        }
        return head.next;

    }

    public static void main(String[] args) {

    }

}
