package com.zyx.leetcode.question0445_add_two_numbers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基于栈实现
 *
 * 链表是单向的，计算需要从各位计算，即链表尾部
 * 分别将两个链表放入两个栈中
 * 则栈顶部在同个数学单位里，自顶向下依次为个十百千...
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);

        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s1.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();

            int sum = n1 + n2 + carry;

            int temp = sum % 10;

            ListNode node = new ListNode(temp);

            node.next = dummy.next;
            dummy.next = node;

            carry = sum / 10;
        }
        return dummy.next;
    }
}
