package com.demo;

/**
 * @author: JunLog
 * @Description: 合并两个有序链表
 * Date: 2022/8/11 11:39
 */
public class _18MergeTwoSortList {
    
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
    }

    // Time:O（m + n） space：O（1）
    public ListNode mergeTwoSortList(ListNode l1, ListNode l2){
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
    
}
