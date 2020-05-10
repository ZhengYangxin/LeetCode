package com.zyx.leetcode.question0543_diameter_of_binary_tree;

public class Solution1 {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        ans = Math.max(ans, (left + right + 1));
        return Math.max(left, right) + 1;
    }
}