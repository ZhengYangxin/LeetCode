package com.zyx.leetcode.question0145_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:35 MB,击败了6.81% 的Java用户
 *
 */
public class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }
}
