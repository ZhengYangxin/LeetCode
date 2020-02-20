package com.zyx.leetcode.question0002_add_two_numbers;

/**
 *
 *
 * 空间复杂度O(n)：n为max(l1.length,l2.length)
 * 空间复杂度O(n)：新列表的长度最多为 1max(m,n)+1
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode currt = root;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);

            currt.next = newNode;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry > 0) {
            currt.next = new ListNode(carry);
        }

        return root.next;
    }

    public static void main(String[] args) {

    }
}
