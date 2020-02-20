package com.zyx.leetcode.question0114_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 递归实现
 */
public class Solution1 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (list == null) {
            return list;
        }

        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
}
