package com.lm.algorithm.middle.linkedlist;


/**
 * @Auther: 田黎明
 * @Date: 2019-04-07 20:57
 * @Description:编写一个程序，找到两个单链表相交的起始节点。 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode c1 = headA, c2 = headB;
        while (c1 != c2) {
            c1 = c1 == null ? headB : c1.next;
            c2 = c2 == null ? headA : c2.next;
        }
        return c1;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int la = getListLength(headA);
        int lb = getListLength(headB);
        ListNode c1, c2;
        c1 = la >= lb ? headA : headB;
        c2 = la >= lb ? headB : headA;
        int sub = Math.abs(la - lb);
        for (int i = 0; i < sub; i++) {
            c1 = c1.next;
        }
        while (c1 != null) {
            if (c1 == c2)
                return c1;
            c1 = c1.next;
            c2 = c2.next;
        }
        return null;
    }

    private int getListLength(ListNode head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }

    public static void main(String[] args) {

    }

}
