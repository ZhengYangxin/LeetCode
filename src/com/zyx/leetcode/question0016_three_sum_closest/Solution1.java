package com.zyx.leetcode.question0016_three_sum_closest;

import java.util.Arrays;

/**
 * 暴力法
 *
 * 三重循环
 *
 * 时间复杂度O(n^3)
 * 空间复杂度O(1)
 *
 * 执行耗时:101 ms,击败了6.65% 的Java用户,内存消耗:38.1 MB,击败了5.05% 的Java用户
 *
 */
public class Solution1 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        int ans = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length - 2; k++) {
            for (int i = k + 1; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (Math.abs(target - ans) > Math.abs(target - sum)) {
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }
}
