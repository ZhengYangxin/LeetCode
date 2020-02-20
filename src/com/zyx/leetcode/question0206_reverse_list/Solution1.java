package com.zyx.leetcode.question0206_reverse_list;

/**
 *
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户,内存消耗:37 MB,击败了46.23% 的Java用户
 *
 */
public class Solution1 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
}
