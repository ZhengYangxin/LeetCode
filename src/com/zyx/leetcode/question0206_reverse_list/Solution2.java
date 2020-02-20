package com.zyx.leetcode.question0206_reverse_list;

public class Solution2 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = reverseList(next.next);
        next.next = head;

        return next;
    }
}
