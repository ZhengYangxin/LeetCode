package com.zyx.leetcode.question0239_max_sliding_window;

/**
 *
 * 暴力法
 * 通过双层遍历，每个窗口进行遍历寻找最大值
 *
 * 时间复杂度O(NK)
 * 空间复杂度O(n)
 *
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] result = solution2.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
