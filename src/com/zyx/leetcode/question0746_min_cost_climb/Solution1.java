package com.zyx.leetcode.question0746_min_cost_climb;

public class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 0; i < cost.length; i++) {
            dp[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }

        return Math.min(dp[len - 1], cost[len - 2]);
    }
}
