package com.zyx.leetcode.question0114_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 基于栈的迭代法
 *
 * 时间复杂度为O(n)
 * 空间复杂度为O(n)，n最大为节点的个数
 * 执行耗时:1 ms,击败了63.50% 的Java用户,内存消耗:35 MB,击败了5.25% 的Java用户
 *
 */
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }
}
