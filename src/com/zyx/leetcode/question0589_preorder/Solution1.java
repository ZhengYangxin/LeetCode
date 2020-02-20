package com.zyx.leetcode.question0589_preorder;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现
 */
public class Solution1 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;

    }

    private void helper(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        if (!node.children.isEmpty()) {
            for (Node child : node.children) {
                helper(child, list);
            }
        }
    }

}
