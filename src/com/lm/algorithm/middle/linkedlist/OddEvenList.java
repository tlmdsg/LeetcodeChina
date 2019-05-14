package com.lm.algorithm.middle.linkedlist;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-07 20:45
 * @Description:给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode oddHead = new ListNode(0), evenHead = new ListNode(0), oddc = oddHead, evenc = evenHead, cur = head;
        boolean isOdd = true;
        while (cur != null) {
            if (isOdd) {
                oddc.next = cur;
                oddc = oddc.next;
            } else {
                evenc.next = cur;
                evenc = evenc.next;
            }
            isOdd = !isOdd;
            cur = cur.next;
        }
        oddc.next = evenHead.next;
        evenc.next = null;
        return oddHead.next;
    }

    public static void main(String[] args) {

    }

}
