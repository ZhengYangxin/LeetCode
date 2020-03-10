package com.zyx.leetcode.interview0201_remove_dumplicate_nodes;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        Set<Integer> set = new HashSet<>();

        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
