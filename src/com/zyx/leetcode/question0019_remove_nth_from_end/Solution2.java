package com.zyx.leetcode.question0019_remove_nth_from_end;

/**
 * 思路
 * 删除倒数第n个数，意味是从头开始的第len-(n-1)的位置，
 * 如果有快慢两个指针，快指针先走n-1步，然后大家一起走，
 * 当快指针走到尾时，快慢指针相隔就刚好是n - 1，慢指针当时所处的位置就是要删除的n节点
 *
 * 现在要找到删除节点的前一个节点，同理可得 快指针先走n， 由于增加了头结点root，所以要走n+1步
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了64.16% 的Java用户,内存消耗:35 MB,击败了19.08% 的Java用户
 *
 */
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        for (int i = 0; i < n+1; i++) {
            if (first != null) {
                first = first.next;
            }
        }

        ListNode second = dummy;
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }

}
