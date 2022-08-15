package com.demo26_50;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: JunLog
 * @Description: 单链表是否有环
 * Date: 2022/8/14 11:15
 */
public class _27HasCycle {

    public class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
    }

    // Time:O（n） space：O（n）
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for(ListNode p = head; p != null; p = p.next) {
            if (set.contains(p)) return true;
            set.add(p);
        }
        return false;
    }

    // Time:O（n） space：O（n）
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

}
