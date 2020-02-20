package com.zyx.leetcode.question0198_rob;

/**
 * 动态规划优化，
 *
 * 每次都假设i必偷的情况
 *
 * nums[i] = Math.max(nums[i-1], nums[i-2] + nums[i])
 *
 */
public class Solution2 {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.rob(new int[]{1,2,3,1});
        System.out.println("result = " + result);
    }
}
