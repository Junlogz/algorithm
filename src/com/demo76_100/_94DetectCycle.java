package com.demo76_100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/8/25 14:41
 */
public class _94DetectCycle {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
    }

    // Time：O(n), Space：O(n)
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; p != null; p = p.next) {
            if (set.contains(p)) return p;
            set.add(p);
        }
        return null;
    }

    // Time：O(n), Space：O(1)
    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                for (ListNode p = head; p != slow; p = p.next, slow = slow.next);
                return slow;
            }
        }
        return null;
    }

}
