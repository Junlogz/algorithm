package com.demo;

/**
 * @author: JunLog
 * @Description: 力扣206. 反转链表
 * Date: 2022/8/9 11:38
 */
public class _09ReverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Time:O（n） space：O（1）
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
