package com.zyx.leetcode.question0094_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 栈迭代法
 *
 * 执行耗时:1 ms,击败了71.07% 的Java用户,内存消耗:34.7 MB,击败了45.31% 的Java用户
 *
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }


}
