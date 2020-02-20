package com.zyx.leetcode.question0098_validate_binary_search;

import java.util.Stack;

/**
 *
 * 判断二叉搜索树的有效性
 * 二叉搜索树的特点
 * 左子树的节点值小于右子树的节点值
 * 左子树的值小于当前值
 * 右子树的值大于当前值
 *
 *
 * 基于二叉树的中序遍历，可以发现搜索二叉树是个有序数组
 *
 * 执行耗时:2 ms,击败了39.38% 的Java用户,内存消耗:39.6 MB,击败了5.07% 的Java用户
 *
 */
public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        int last = Integer.MIN_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            if (node.val < last) {
                return false;
            }
            last = node.val;
            cur = node.right;

        }
        return true;
    }
}
