package com.demo51_100;

/**
 * @author: JunLog
 * @Description: 删除单链表倒数第N个节点
 * Date: 2022/8/19 11:27
 */
public class _52RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // Time：O(k), Space：O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, q = dummy;

        for (; n > 0 && q.next != null; --n) q = q.next;
        if (n != 0) return dummy.next;

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

}
