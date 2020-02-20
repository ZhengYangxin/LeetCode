package com.zyx.leetcode.question0019_remove_nth_from_end;

/**
 *
 * 思路
 * 1. 删除倒数第k个节点， 由于链表是单向链表，我们只能从左到右的遍历，所以需要推算出从左到右的步数
 * 2. 假设链表长度为n，那要删除的节点，则需要走n -（k - 1）步 = n-k+1
 * 3. 所以可以首先得到链表额长度，通过循坏链表计数，因为要删除的节点是n-k+1，则要删除的前一个节点则为n-k
 * 4. 得到要删除的前一节点node， 删除操作则为node.next = node.next.next
 *
 * 时间复杂度O(n)：但是需要两次链表循环
 * 空间复杂度O(1)
 * 执行耗时:1 ms,击败了64.16% 的Java用户，内存消耗:34.9 MB,击败了41.63% 的Java用户
 *
 *
 */
public class Solution1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;

        int length = 0;

        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        // 要删除位置
        length -= n;

        cur = root; // 从新的头结点开始，不是从cur = head开始
        for (int i = 0; i < length; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return root.next;
    }

}
