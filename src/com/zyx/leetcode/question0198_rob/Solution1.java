package com.zyx.leetcode.question0198_rob;

/**
 * 1. 子问题（分治）
 * 2. 状态方程 nums[i]
 * 3. DP方程  nums[i] = nums[i-1]  +num[i]  错误， 需要知道nums[i-1]是否偷了
 * if nums[i-1] == 偷了
 * nums[i] = nums[i-1]
 * else
 * nums[i] = nums[i-1]  + num[i]
 *
 *
 * 因此需要添加是否被偷的信息
 * nums[i][0,1] i  0 没偷，1 偷了
 *
 * nus[i][0] = Math.max(nums[i-1][0], nums[i-1][1]) 当前i没偷， 则最大值可以是之前没偷，偷的中大的那个
 * nus[i][1] = nums[i-1][0] + nus[i] 当前i偷了， 则最大值是之前没偷 + 当前i值
 *
 */
public class Solution1 {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.rob(new int[]{1,2,3,1});
        System.out.println("result = " + result);
    }

}
