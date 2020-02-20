package com.zyx.leetcode.question0021_merge_two_lists;

/**
 *
 * 递归法
 *
 * 时间复杂度O(m+n)：n为(l1.length+l2,length)
 * 空间复杂O(n)：递归调用消耗栈帧
 *
 * 执行耗时:1 ms,击败了87.10% 的Java用户,内存消耗:38.6 MB,击败了39.69% 的Java用户
 *
 */
public class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
