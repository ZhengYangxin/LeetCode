package com.zyx.leetcode.question0145_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 基于栈的迭代法
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 执行耗时:1 ms,击败了65.71% 的Java用户，内存消耗:34.8 MB,击败了28.72% 的Java用户
 *
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.peek();
                if (node.right != null && node.right != last) {
                    cur = node.right;
                } else {
                    list.add(node.val);
                    last = node;
                    stack.pop();
                }
            }

        }

        return list;
    }
}
