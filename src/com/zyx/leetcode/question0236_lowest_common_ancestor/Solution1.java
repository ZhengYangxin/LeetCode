package com.zyx.leetcode.question0236_lowest_common_ancestor;

/**
 * 在左右子树中寻找指定的p，q两个节点，当找到不到时返回false，同时判断当前节点是否是指定节点，
 * 如果是则返回1，当前节点的左右子树分别包含p，q节点
 *
 * 执行耗时:8 ms,击败了99.64% 的Java用户,内存消耗:39.3 MB,击败了5.01% 的Java用户
 */
public class Solution1 {
    public static TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        int left = helper(node.left, p, q) ? 1 : 0;
        int right = helper(node.right, p, q) ? 1 : 0;

        int mid = ((node == p) || (node == q)) ? 1 : 0;

        if (mid + left + right >= 2) {
            ans = node;
        }

        return (left + right + mid) > 0;
//        boolean left = helper(node.left, p, q);
//        boolean right = helper(node.right, p, q);
//
//        if (left && right) {
//            ans = node;
//        }
//
//        return ((node == p) || (node == q));
    }
}
