package com.zyx.leetcode.question0236_lowest_common_ancestor;

/**
 *
 * 递归实现
 * 左右子树
 * 若在左右子树中分别找到了，p， q，则当前节点为公共子树
 * 否则在其中一颗子树，继续左右寻找
 *
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

}
