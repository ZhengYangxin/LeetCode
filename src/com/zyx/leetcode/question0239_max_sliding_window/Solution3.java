package com.zyx.leetcode.question0239_max_sliding_window;

import java.util.*;

/**
 *
 * 通过最大堆，获取顶部最大值
 *
 * 时间复杂度O(nlogk)
 * 空间复杂度O(n)
 *
 * 执行耗时:103 ms,击败了5.00% 的Java用户
 * 			内存消耗:47.8 MB,击败了5.02% 的Java用户
 *
 *
 *
 */
public class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() == k) {
                queue.remove(nums[i - k]);
            }
            queue.add(nums[i]);

            if (i >= k - 1) {
                result[i - k + 1] = queue.peek();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] result = solution3.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
