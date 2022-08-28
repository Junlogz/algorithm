package com.demo76_100;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: JunLog
 * @Description: 23. 合并K个升序链表
 * Date: 2022/8/25 10:06
 */
public class _90MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
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

    public ListNode merge(ListNode[] list, int start, int end) {
        if (start == end) return list[start];
        if (start > end) return null;
        int mid = start + ((end - start)) >> 1;
        ListNode left = merge(list, start, mid);
        ListNode right = merge(list, mid + 1, end);
        return mergeTwoSortList(left, right);
    }

    // Time：O(n*log(k)), Space：O(log(k))
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    // Time：O(n*log(k)), Space：O(k)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                q.add(list);
            }
        }
        ListNode dummy = new ListNode(0), p = dummy;
        while (!q.isEmpty()) {
            ListNode min = q.poll();
            p.next = min;
            p = p.next;
            if (min.next != null) q.add(min.next);
        }
        return dummy.next;
    }

}
