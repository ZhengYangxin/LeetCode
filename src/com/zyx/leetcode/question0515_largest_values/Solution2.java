package com.zyx.leetcode.question0515_largest_values;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 深度优先遍历
 * 执行耗时:1 ms,击败了100.00% 的Java用户
 * 			内存消耗:39.6 MB,击败了5.23% 的Java用户
 *
 *
 */
public class Solution2 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {  // 输入为null
            return res;
        }
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode node, int level, List<Integer> res) {
        if (level == res.size()) {
            res.add(level, node.val);
        }

        res.set(level,Math.max(res.get(level),node.val));
        if (node.left != null) {
            helper(node.left, level + 1, res);
        }

        if (node.right != null) {
            helper(node.right, level + 1, res);
        }
    }
}
