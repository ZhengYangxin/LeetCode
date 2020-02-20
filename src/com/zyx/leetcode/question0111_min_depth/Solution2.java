package com.zyx.leetcode.question0111_min_depth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于广度优先遍历
 *
 * 在统计每一层的时候增加level， 队列弹出的节点是个叶子节点事，则表示为当前树的最小深度
 *
 * 时间复杂度为O(n)
 * 空间复杂度O(n)
 * 执行耗时:0 ms,击败了100.00% 的Java用户,内存消耗:39.1 MB,击败了10.11% 的Java用户
 */
public class Solution2 {

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int level = 1;
        queue.add(root);
        while (queue != null) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            level++;
        }

        return level;
    }

}
