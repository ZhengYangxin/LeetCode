package com.zyx.leetcode.base_structure;

public class ReserveLink {

    public void reserve(ListNode root) {
        ListNode pre = null, cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
