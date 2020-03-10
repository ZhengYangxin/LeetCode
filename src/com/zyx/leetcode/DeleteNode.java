package com.zyx.leetcode;

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        ListNode root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);
        ListNode result = deleteNode.deleteNode(root, 5);

        while (result != null) {
            System.out.println("result = " + result.val);
            result = result.next;
        }
    }
}
