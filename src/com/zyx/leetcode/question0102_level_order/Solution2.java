package com.zyx.leetcode.question0102_level_order;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先遍历
 *
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        helper(root, 0, levels);
        return levels;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> levels) {
        if (node == null) {
            return;
        }

        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        helper(node.left, level + 1, levels);
        helper(node.right, level + 1, levels);
    }

}
