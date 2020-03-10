package com.zyx.leetcode.question0092_reverse_between;

public class Solution1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution1 solution1 = new Solution1();
        ListNode listNode = solution1.reverseBetween(head, 2, 4);

        int count = 0;
        while (listNode != null && count < 6) {
            count++;
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

        System.out.println('a' + 0);
        System.out.println('A' + 0);

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = null;
        ListNode curr = dummy;
        for (int i = 0; i < m; i++) {
            pre = curr;
            curr = curr.next;
            n--;
        }
        //     conn  tail
//             pre   curr
//       dummy  1     2    3     4     5   6
        ListNode conn = pre, tail = curr;
        for (int i = 0; i < n + 1; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        if (conn != null) {
            conn.next = pre;
        } else {
            dummy.next = pre;
        }

        tail.next = curr;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
