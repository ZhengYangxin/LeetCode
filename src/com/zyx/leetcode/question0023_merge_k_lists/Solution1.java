package com.zyx.leetcode.question0023_merge_k_lists;

/**
 *
 *
 * 思路，
 * 1. 将数组长度为len平分len/2，然后进行左右对称的合并，合并结果保留在前半部分，然后对于合并完毕的数组长度len = (len + 1)/2
 * 2. 进行上面一样的操作，直到只剩len = 1
 *
 * 时间复杂度O(nlon)
 * 空间复杂度O(1)
 * 执行耗时:2 ms,击败了100.00% 的Java用户，内存消耗:41 MB,击败了57.41% 的Java用户
 *
 */
public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = 0;
        if (null == lists || (len = lists.length) == 0) {
            return null;
        }

        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoNode(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }

        return lists[0];
    }

    private ListNode mergeTwoNode(ListNode head1, ListNode head2) {
        ListNode root = new ListNode(0);
        ListNode p = head1;
        ListNode q = head2;
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

        return root.next; // 第一次结题错误，返回值root是头结点，并非开始节点
    }
}
