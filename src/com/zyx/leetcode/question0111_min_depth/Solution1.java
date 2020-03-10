package com.zyx.leetcode.question0111_min_depth;

/**
 * 时间复杂度为O(n)：每个节点都会被访问
 *
 * 时间复杂度O(logN)：最坏情况是链表O(n)， 好的情况树是平衡的O(logn)
 *
 *
 * DFS 基于深度优先遍历
 *
 * 获取左子树的的深度，获取右子树的深度，获取小的深度加上自己节点则为最小深度
 * 当左子树，或者右子树为0，则为非0子树+本身子树
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right);
    }
}
