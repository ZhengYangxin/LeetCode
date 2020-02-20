package com.zyx.leetcode.question0104_max_depth;

import java.util.*;

/**
 *
 * 基于广度优先遍历
 *
 * 一层以为深度1
 *
 * 执行耗时:2 ms,击败了9.38% 的Java用户,内存消耗:39.1 MB,击败了9.20% 的Java用户
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.maxDepth(null);
        System.out.println(i);
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);

                }
            }
            level++;
        }

        return level;
    }
}
