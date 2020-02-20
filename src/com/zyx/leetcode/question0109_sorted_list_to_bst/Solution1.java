package com.zyx.leetcode.question0109_sorted_list_to_bst;

/**
 * 有序链表转搜索二叉树
 *
 * 搜索二叉树的特点是
 * 左子树的所有节点都小于付节点
 * 右子树的所有节点都大于父节点
 *
 * 所以我们可以先找到链表的中间数，中间数即根节点
 * 中间数左边是左子树，右边是右子树
 *
 * 同理递归左右链表
 */
public class Solution1 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode mid = getMidNode(head);

        TreeNode node = new TreeNode(mid.val);

        // 说明只有一个节点
        if (head == mid) {
            return node;
        }

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }
}
