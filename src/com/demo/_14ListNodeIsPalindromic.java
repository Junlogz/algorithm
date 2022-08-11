package com.demo;

import java.util.Stack;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/8/10 14:36
 */
public class _14ListNodeIsPalindromic {

    public class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            x = val;
        }
    }

    // Time:O（n） space：O（n）
    public boolean listNodeIsPalindromic1 (ListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode p = head; p != null; p = p.next)
            stack.push(p.val);
        for (ListNode p = head; p != null; p = p.next)
            if (p.val != stack.pop())
                return false;
        return true;
    }

    // Time:O（n） space：O（1）
    public boolean listNodeIsPalindromic2 (ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next, ++len);

        ListNode cur = head, pre= null;
        for (int i = 0; i < len / 2; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 如果为链表为奇数个节点 中间那个不用管 cur+1 从两边判断
        if (len % 2 == 1) cur = cur.next;

        for (; pre != null && cur != null; pre = pre.next, cur = cur.next)
            if (pre.val != cur.val) return false;
        return true;
    }

}
