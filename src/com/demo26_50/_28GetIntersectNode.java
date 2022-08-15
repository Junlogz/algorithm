package com.demo26_50;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/8/14 11:49
 */
public class _28GetIntersectNode {

    public class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
    }

    // Time:O（n + m） space：O（1）
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        for (ListNode p = headA; p != null; p = p.next, ++lenA);
        for (ListNode p = headB; p != null; p = p.next, ++lenB);

        ListNode p = headA, q = headB;
        if (lenA > lenB)
            for(int i = 0; i < lenA - lenB; ++i) p = p.next;
        else
            for(int i = 0; i < lenB - lenA; ++i) q = q.next;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    // Time:O（n + m） space：O（1）
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : p.next;
        }
        return p;
    }

}
