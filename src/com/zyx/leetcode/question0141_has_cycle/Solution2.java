package com.zyx.leetcode.question0141_has_cycle;

/**
 * 快慢指针法
 * 思路
 * 1.通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。慢指针每次移动一步，而快指针每次移动两步。
 * 2. 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
 * 3. 如果存在环，快指针最终会追上慢指针，即会相遇
 * 注意：
 * 对快指针的判空处理
 *
 * 时间复杂度O(n)： 非环部分与环形部分的长度
 * 空间复杂度O(1)：只使用了慢指针和快指针两个结点
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:37.1 MB,击败了76.68% 的Java用户
 *
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null ) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }
}
