package com.lm.algorithm.middle.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-07 19:56
 * @Description:给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        ListNode head = new ListNode(0);
        ListNode c1 = l1, c2 = l2, c = head;
        int add = 0;
        while (c1 != null || c2 != null || add == 1) {
            if (c1 != null && c2 != null) {
                int v = c1.val + c2.val + add;
                add = v >= 10 ? 1 : 0;
                c.next = new ListNode(v % 10);
                c1 = c1.next;
                c2 = c2.next;
            } else if (c1 != null) {
                int v = c1.val + add;
                add = v >= 10 ? 1 : 0;
                c.next = new ListNode(v % 10);
                c1 = c1.next;
            } else if (c2 != null) {
                int v = c2.val + add;
                add = v >= 10 ? 1 : 0;
                c.next = new ListNode(v % 10);
                c2 = c2.next;
            }else {
                c.next = new ListNode(1);
                break;
            }
            c = c.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }

}
