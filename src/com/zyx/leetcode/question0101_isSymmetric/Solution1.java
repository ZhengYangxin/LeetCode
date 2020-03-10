package com.zyx.leetcode.question0101_isSymmetric;

public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return (node1.val == node2.val)
                && helper(node1.left, node2.right)
                && helper(node1.right, node2.left);
    }
}
