package com.zyx.leetcode.question0138_copy_random_list;

/**
 *
 * 通过复制节点是实现
 * 执行耗时:0 ms,击败了100.00% 的Java用户,内存消耗:41.4 MB,击败了5.06% 的Java用户
 *
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // 添加复制节点 A-A'-B-B'-C-C'
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        //为复制节点添加random指针
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }

        // 拆分新老链表 A-B-C-D  A'-B'-C'-D'
        Node old_list = head;
        Node new_list = head.next;
        Node new_head = head.next;

        while (old_list != null) {
            old_list.next = old_list.next.next;
            new_list.next = new_list.next != null ? new_list.next.next : null;

            old_list = old_list.next;
            new_list = new_list.next;
        }
        return new_head;

    }
}
