package com.zyx.leetcode.question0024_swap_pairs;

/**
 * 迭代法
 *
 * 为了避免讨论头结点，都会申请一个空节点指向头节点，然后再用一个指针遍历整个链表
 *
 * 交换节点
 * pre.next = secordNode;
 * firstNode.next = secordNode.next;
 * secondNode.next = firstNode;
 *
 * point = swap1
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:34.5 MB,击败了18.61% 的Java用户
 *
 */
public class Solution1 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode firstNode = cur;
            ListNode secondNode = cur.next;

            //  替换顺序  pre 1 2 next
            pre.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 重置 pre cur
            pre = firstNode;
            cur = firstNode.next;
        }
        return dummy.next;
    }

}
