package com.zyx.leetcode.question0160_get_interselection_node;

public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode q = headA, p = headB;

        while (p != q) {
            p = p != null ? p.next : headA;
            q = q != null ? q.next : headB;
        }
        return p;
    }

}
