package com.zyx.leetcode.question0082_delete_duplicates;

/**
 *
 * 首先创建一个哑结点指向头结点
 * 定义初始化pre节点即哑结点， cur节点为头结点
 * 比较当前节点与下一个节点是否相等，相等则找到不同的节点跳过该节点，不等则更新pre和next
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 *
 * 执行耗时:1 ms,击败了98.75% 的Java用户,内存消耗:36.8 MB,击败了13.37% 的Java用户
 *
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
//                          next
//                pre 1 1 1  2   去除111
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;
                }
                ListNode next = curr.next;
                pre.next = next;
                curr = next;
            } else {
                pre = pre.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
