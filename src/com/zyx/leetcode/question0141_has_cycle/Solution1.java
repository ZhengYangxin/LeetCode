package com.zyx.leetcode.question0141_has_cycle;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希法
 * 思路
 * 1. 遍历链表，通过哈希表记录节点，当遇到相同节点则表示存在环
 *
 * 时间复杂度为O(n)：对于含有 n 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1)O(1) 的时间
 * 空间复杂度为O(n)：空间取决于添加到哈希表中的元素数目，最多可以添加 nn 个元素
 *
 * 执行耗时:6 ms,击败了25.79% 的Java用户，内存消耗:38.4 MB,击败了8.64% 的Java用户
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
