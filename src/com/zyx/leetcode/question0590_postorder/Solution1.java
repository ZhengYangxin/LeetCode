package com.zyx.leetcode.question0590_postorder;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (!node.children.isEmpty()) {
            for (Node child : node.children) {
                helper(child, list);
            }
        }
        list.add(node.val);
    }
}
