package com.zyx.leetcode.question0429_level_order;

import java.util.*;

/**
 *
 * 队列法
 *
 * 执行耗时:3 ms,击败了77.86% 的Java用户，内存消耗:40.8 MB,击败了69.44% 的Java用户
 *
 */
public class Solution1 {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    queue.addAll(node.children);
                }
            }
            list.add(level);
        }
        return list;
    }
}
