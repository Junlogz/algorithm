package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 82. 删除排序链表中的重复元素 II
 * Date: 2022/8/23 9:52
 */
public class _74DeleteDuplicates2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // Time：O(n), Space：O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = prev.next;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            // update prev
            if (prev.next != cur) prev.next = cur.next;
            else prev = prev.next;
            // update cur
            cur = prev.next;
        }
        return dummy.next;
    }

}
