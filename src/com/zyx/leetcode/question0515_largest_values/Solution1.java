package com.zyx.leetcode.question0515_largest_values;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历
 *
 * 执行耗时:2 ms,击败了84.10% 的Java用户
 * 			内存消耗:37.4 MB,击败了71.96% 的Java用户
 *
 */
public class Solution1 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode maxNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (maxNode == null) {
                    maxNode = node;
                } else if (maxNode != null && maxNode.val < node.val) {
                    maxNode = node;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(maxNode.val);
        }
        return res;
    }
}
