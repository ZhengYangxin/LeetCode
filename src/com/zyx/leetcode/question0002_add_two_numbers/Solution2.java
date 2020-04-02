package com.zyx.leetcode.question0002_add_two_numbers;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode a, ListNode b, int carry) {
        // terminator 终止条件
        if (a == null && b == null) {
            return carry > 0 ? new ListNode(1) : null;
        }

        // current logic  当前层逻辑处理
        // 如果当前节点a,b启动一个为null，则赋值为ListNode(0)，方便计算
        a = a == null ? new ListNode(0) : a;
        b = b == null ? new ListNode(0) : b;

        // 当前两链表节点的和
        int sum = a.val + b.val + carry;
        carry = sum / 10;
        // 将取模结果保存在第一个链表中
        a.val = sum % 10;
        // driil down   进入下一层递归
        a.next = add(a.next, b.next, carry);
        return a;
    }
}
