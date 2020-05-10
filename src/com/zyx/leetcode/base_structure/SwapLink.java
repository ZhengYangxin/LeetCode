package com.zyx.leetcode.base_structure;

public class SwapLink {

    public void reserve(ListNode root) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = root;
        while (root != null && root.next != null) {
            ListNode first = cur;
            ListNode second = cur.next;

            ListNode next = second.next;
            first.next = next;
            second.next = first;
            pre.next = second;

            pre = first;
            cur = first.next;
        }
    }
}
