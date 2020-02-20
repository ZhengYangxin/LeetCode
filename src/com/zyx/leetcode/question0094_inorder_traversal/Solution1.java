package com.zyx.leetcode.question0094_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户,内存消耗:35.1 MB,击败了5.16% 的Java用户
 *
 */
public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        helper(root, list);

        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
