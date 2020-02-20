package com.zyx.leetcode.question0024_swap_pairs;

/**
 * 递归实现
 *
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:34.6 MB,击败了14.02% 的Java用户
 *
 */
public class Solution2 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
