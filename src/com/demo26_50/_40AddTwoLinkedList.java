package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 两个链表相加
 * Date: 2022/8/17 10:02
 */
public class _40AddTwoLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {val = x;}
    }

    // Time:O（max(m,n)） space：O（max(m,n)）
    public ListNode addTwoLinkedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }
        return dummy.next;
    }

}
