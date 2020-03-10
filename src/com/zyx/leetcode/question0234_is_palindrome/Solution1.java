package com.zyx.leetcode.question0234_is_palindrome;

public class Solution1 {
    public boolean isPalindrome(ListNode head) {

        ListNode midNode = getMidNode(head);

        ListNode head2 = reserve(midNode);

        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        ListNode root = new ListNode(0);
        root.next = new ListNode(0);
//        root.next.next = new ListNode(1);
        boolean result = solution1.isPalindrome(root);
        System.out.println("result = " + result);
    }

    private ListNode reserve(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
}
