package com.demo76_100;


/**
 * @author: JunLog
 * @Description: 148. 排序链表
 * Date: 2022/8/29 9:01
 */
public class _96SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {val = x;}
    }

    private void swap(ListNode a, ListNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    private void quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) return;
        int pivot = head.val;
        ListNode slow = head, fast = head.next;
        while (fast != end) {
            if (fast.val <= pivot) {
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }
        swap(head, slow);
        quickSort(head, slow);
        quickSort(slow.next, end);
    }

    // Time：O(n*log(n)), Space：O(n)
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    public ListNode mergeTwoSortList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummy.next;
    }

    // Time：O(n*log(n)), Space：O(log(n))
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList2(slow.next);
        slow.next = null;
        ListNode left = sortList2(head);
        return mergeTwoSortList(left, right);
    }

}
