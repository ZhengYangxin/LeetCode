package com.zyx.leetcode.question0148_sort_list;

public class Solution1 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(1);
//        ListNode r = new ListNode(4);
//        ListNode root = new ListNode(4);
//        ListNode root = new ListNode(4);
        ListNode newRoot = solution1.sortList(root);

    }
}
