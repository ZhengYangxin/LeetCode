package com.zyx.leetcode.question0226_invert_tree;

/**
 *
 * 时间复杂度O(n)：每个节点都需要被访问
 * 空间复杂度O(n)： 树的高度
 * 执行耗时:0 ms,击败了100.00% 的Java用户,内存消耗:34.5 MB,击败了5.28% 的Java用户
 *
 */
public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.right = left;
//        root.left = right;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


}
