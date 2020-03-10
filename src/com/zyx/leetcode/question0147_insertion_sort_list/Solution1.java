package com.zyx.leetcode.question0147_insertion_sort_list;

public class Solution1 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode tail = dummy; // 记录尾部节点，避免重头遍历比较大小
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val > tail.val) {
                tail.next = cur;
                tail = tail.next;
                cur = cur.next;
            } else {
                ListNode next = cur.next;
                tail.next = next;
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
//                  pre     cur
//                1  3  5  6 4 next
                cur.next = pre.next;
                pre.next = cur;
                pre = dummy;
                cur = next;

            }
        }
        return dummy.next;
    }
}
