package com.zyx.leetcode.question0143_reorder_list;

public class Solution1 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = getMidNode(head);

        ListNode pre = null;
        ListNode cur = mid;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode dummy = new ListNode(0);
        ListNode newCur = dummy;

        while (head != null && pre != null) {
            newCur.next = head;
            head = head.next;

            newCur.next.next = pre;
            pre = pre.next;

            newCur = newCur.next.next;
        }

        head = dummy.next;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        Solution1 solution1 = new Solution1();
        solution1.reorderList(root);

    }
}
