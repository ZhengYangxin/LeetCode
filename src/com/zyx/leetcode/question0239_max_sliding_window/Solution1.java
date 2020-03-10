package com.zyx.leetcode.question0239_max_sliding_window;

import java.util.LinkedList;

/**
 *
 * 双端队列
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 执行耗时:12 ms,击败了74.84% 的Java用户
 * 			内存消耗:47.8 MB,击败了5.02% 的Java用户
 *
 */
public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        LinkedList<Integer> list = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[list.peekLast()] < nums[i]) {
                list.pollLast();
            }

            list.addLast(i);
            if (list.peek() <= i - k) {
                list.poll();
            }

            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = solution1.maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.println("ints = " + anInt);
        }
    }
}
