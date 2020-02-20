package com.zyx.leetcode.question0098_validate_binary_search;

/**
 *
 * 搜索树的的有效性
 * 对于根节点它的范围可以是[NAL, NAL]
 * 对于左节点它的范围是[NAL， 根节点的值）
 * 对于右节点它的范围是[根节点的值， NAL）
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 只要判断节点的有效范围就可以判断搜索二叉树的有效性，所以通过递归可以实现
 *
 */
public class Solution2 {
    public boolean isValideBts(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
