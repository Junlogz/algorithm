package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 剑指 Offer 18. 删除链表的节点
 * Date: 2022/8/18 10:35
 */
public class _48RemoveLinkedList {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // Time:O（n） space：O（1）
    public ListNode remove(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode notEqual = dummy;

        while (notEqual.next != null) {
            if (notEqual.next.val == val) notEqual.next = notEqual.next.next;
            else notEqual = notEqual.next;
        }
        return dummy.next;
    }

}
