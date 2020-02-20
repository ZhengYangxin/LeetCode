package com.zyx.leetcode.question0714_max_profit;

/**
 *
 * 动态规划
 * 状态数组
 * dp[i][j]  i 为天数， j为是否持有股票 0，1
 *
 * dp方程
 * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee)
 * dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
 *
 */
public class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 == -1) {
                dp[0][0] = 0;
                dp[0][1] = - prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.maxProfit(new int[]{1,3,2,8,4,9}, 2);
        System.out.println("result = " + result);
    }
}
