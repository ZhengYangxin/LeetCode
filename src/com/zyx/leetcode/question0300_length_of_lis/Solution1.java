package com.zyx.leetcode.question0300_length_of_lis;

/**
 *
 * 最长上升子序列的长度
 *
 * 从题目可以看出是求最优解的问题，且最优解又可以从子问题中构建，所有可以通过动态规划解决
 * 1. 状态定义 dp[i]
 * 2. dp方程定义
 *
 * 在i在之前的元素，与当前元素可能构成了上升序列，所以需要遍历j[0,i)之间找到最长子序列
 * if nums[i] > nums[j]
 * maxVal = Math.max(maxVal, dp[j])
 *
 *
 * dp[i] = maxVal + 1
 *
 */
public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int maxans = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, -1};
        Solution1 solution1 = new Solution1();
        int result = solution1.lengthOfLIS(nums);
        System.out.println("result = " + result);
    }
}
