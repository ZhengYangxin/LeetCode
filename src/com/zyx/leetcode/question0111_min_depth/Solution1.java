package com.zyx.leetcode.question0111_min_depth;

/**
 * 时间复杂度为O(n)：每个节点都会被访问
 *
 * 时间复杂度O(logN)：最坏情况是链表O(n)， 好的情况树是平衡的O(logn)
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDeth = Integer.MAX_VALUE;

        if (root.left != null) {
            minDeth = Math.min(minDepth(root.left), minDeth);
        }

        if (root.right != null) {
            minDeth = Math.min(minDepth(root.right), minDeth);
        }

        return minDeth;

    }
}
