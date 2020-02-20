package com.zyx.leetcode.question0142_detectCycle;

public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = getMeetNode(head);
        if (meetNode == null) {
            return null;
        }

        ListNode p1 = meetNode;
        ListNode p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode getMeetNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return fast;
            }
        }
        return null;
    }
}
