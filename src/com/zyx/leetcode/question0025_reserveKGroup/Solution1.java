package com.zyx.leetcode.question0025_reserveKGroup;

/**
 *
 * 结题思路类似于24题，主要一点书一组里面节点的反转
 *
 * 时间复杂度为O(n)
 * 空间复杂度为O(1)
 *
 * 执行耗时:1 ms,击败了76.08% 的Java用户，内存消耗:36.2 MB,击败了95.06% 的Java用户
 *
 */
public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) { // 当分组长度不足k时，end = null，则退出循环不做交换处理
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;
            pre.next = reserve(start);
            start.next = next;

            pre = start;

            end = pre;

        }

        return dummy.next;
    }

    private ListNode reserve(ListNode start) {
        ListNode pre = null;
        ListNode cur = start;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }
}
