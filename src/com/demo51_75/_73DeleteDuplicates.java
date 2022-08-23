package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 83. 删除排序链表中的重复元素
 * Date: 2022/8/23 9:52
 */
public class _73DeleteDuplicates {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // Time：O(n), Space：O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, next = head.next;
        while (next != null) {
            if (cur.val == next.val)
                cur.next = next.next;
            else
                cur = cur.next;
            next = next.next;
        }
        return head;
    }

}
