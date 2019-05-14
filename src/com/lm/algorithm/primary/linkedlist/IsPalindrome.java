package com.lm.algorithm.primary.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 16:08
 * @Description:请判断一个链表是否为回文链表。 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 */

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int n = length / 2;
        ListNode reverse = null, next = null;
        cur = head;
        for (int i = 0; i < n; i++) {
            next = cur.next;
            cur.next = reverse;
            reverse = cur;
            cur = next;
        }
        if ((length & 0x1) == 1) {
            cur = cur.next;
        }
        for (int i = 0; i < n; i++, cur = cur.next, reverse = reverse.next) {
            if (cur.val != reverse.val)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
