package com.zyx.leetcode.question0083_delete_duplicates_2;

/**
 *
 * 与82的思想类似，但会保留一个重复节点
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了98.66% 的Java用户,内存消耗:36.8 MB,击败了26.53% 的Java用户
 *
 */
public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.val != curr.val) {
                pre = pre.next;
                curr = curr.next;
            } else {
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;
                }

                // pre 1 1 1 next
                pre.next = curr;
                pre = pre.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
