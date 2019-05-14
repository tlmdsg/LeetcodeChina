package com.lm.algorithm.senior.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-21 14:19
 * @Description:链表排序
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head, pre = null;
        while (fast != null) {
            if (fast.next != null)
                fast = fast.next.next;
            else
                fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode l = head, r = slow;
        return merge(mergeSort(l), mergeSort(r));
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(0), cur = head;
        while (l != null || r != null) {
            if (l != null && r != null) {
                if (l.val < r.val) {
                    cur.next = l;
                    l = l.next;
                } else {
                    cur.next = r;
                    r = r.next;
                }
                cur = cur.next;
            } else if (l != null) {
                cur.next = l;
                break;
            } else {
                cur.next = r;
                break;
            }
        }
        return head.next;
    }

    public ListNode sortList1(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head, sortHead = new ListNode(Integer.MIN_VALUE), sortCur, pre, next;
        while (cur != null) {
            pre = null;
            sortCur = sortHead;
            while (sortCur != null) {
                if (sortCur.val <= cur.val) {
                    pre = sortCur;
                    sortCur = sortCur.next;
                } else {
                    pre.next = cur;
                    next = cur.next;
                    cur.next = sortCur;
                    cur = next;
                    break;
                }
                if (sortCur == null) {
                    pre.next = cur;
                    next = cur.next;
                    cur.next = sortCur;
                    cur = next;
                }
            }
        }
        return sortHead.next;
    }

    public static void main(String[] args) {

    }

}
