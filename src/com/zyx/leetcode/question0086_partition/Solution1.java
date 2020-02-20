package com.zyx.leetcode.question0086_partition;

/**
 *
 * 时间复杂度O(n)
 *
 *空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了76.00% 的Java用户,内存消耗:36 MB,击败了13.00% 的Java用户
 *
 */
public class Solution1 {
    public static void main(String[] args) {

    }
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode p = before;
        ListNode q = after;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;  // 后尾节点置空，否则可能循环
        p.next = after.next;
        return before.next;
    }
}
