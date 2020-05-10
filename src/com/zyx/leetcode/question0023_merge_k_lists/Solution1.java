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
        // len 为1就只有一个链表，直接返回lists[0]，否则需要做首尾分治合并
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoNode(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }

        return lists[0];
    }

    private ListNode mergeTwoNode(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(p != null && q != null) {
            if (p.val < q.val) {
                curr.next = p;
                p = p.next;
            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }

        curr.next = p != null ? p : q;
        
        return dummy.next;
    }
}
