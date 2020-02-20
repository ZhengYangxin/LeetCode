package com.zyx.leetcode.question0061_rotate_right;

/**
 *
 * 因为是单向链表，所以只能顺序遍历，想让链表能移动，只能让链表成环，
 * 然后同构断环某个节点成为头结点，达到移动的效果
 *
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        new int[]{1, 2, 3, 4, 5}
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = solution1.rotateRight(head, 2);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null ) {
            return head;
        }
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        tail.next = head;

        ListNode newTail = head;
        int length = (n - (k % n) - 1);
        while (length > 0) {
            length--;
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
