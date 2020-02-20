package com.zyx.leetcode.question0589_preorder;

import java.util.*;

/**
 * 基于栈的实现
 *
 * 时间复杂度为O(n)
 * 空间复杂度为O(n)
 * 执行耗时:4 ms,击败了35.94% 的Java用户，内存消耗:41.2 MB,击败了26.39% 的Java用户
 *
 */
public class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                list.add(node.val);
                if (!node.children.isEmpty()) {
                    Collections.reverse(node.children);
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.add(node.children.get(i));
                    }
                }
            }
        }

        return list;

    }


}
