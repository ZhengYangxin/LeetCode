package com.zyx.leetcode.question0021_merge_two_lists;

/**
 * 迭代法
 *
 * 时间复杂度O(m+n)：n为(l1.length+l2,length)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了87.10% 的Java用户,内存消耗:38.6 MB,击败了39.69% 的Java用户
 *
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);  // root节点不能用于操作,只做返回
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = root;
        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        cur.next = p != null ? p : q;

        return root.next;
    }
}
