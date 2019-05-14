package com.lm.algorithm.primary.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 16:30
 * @Description:给定一个链表，判断链表中是否有环。
 */

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null)
                return false;
            fast = fast.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
