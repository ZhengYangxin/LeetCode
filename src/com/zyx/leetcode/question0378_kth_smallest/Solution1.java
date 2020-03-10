package com.zyx.leetcode.question0378_kth_smallest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  基于优先队列
 *
 *  最大堆 对顶为第k大的数字
 *
 * 执行耗时:23 ms,击败了34.33% 的Java用户
 * 			内存消耗:46.8 MB,击败了5.07% 的Java用户
 */
public class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        if (null == matrix || matrix.length == 0) {
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(matrix[i][j]);
                } else if (priorityQueue.peek() > matrix[i][j]) {
                    priorityQueue.poll();
                    priorityQueue.add(matrix[i][j]);
                }
            }
        }
        return priorityQueue.poll();
    }
}
