package com.zyx.leetcode.question0001_two_sum;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 暴力法
 * 思路
 * 1. 双重循环，
 *
 * 时间复杂度O(n^2)：n为数组长度
 * 空间复杂度O(1)
 * 执行耗时:30 ms,击败了27.03% 的Java用户, 内存消耗:37.5 MB,击败了37.17% 的Java用户
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = target - nums[i];
                if (num == nums[j]) {
                    return new int[]{i, nums[j]};
                }
            }
        }

        return new int[0];
    }
}
