package com.zyx.leetcode.question0121_max_profit;

/**
 *
 *
 * a[i][j]  j =0 没买， 1 买了
 *
 * 1. 当前没有买入股票
 *  1. 昨天没有买入股票
 *  2. 昨天买入股票，然后今天卖出了股票
 * a[i][0] = Math.max(a[i-1][0], a[i-1][1]+ nums[i])
 *
 * 2. 当前买入了股票
 *  1. 昨天买入了股票
 *  2. 昨天没买股票，今天买入了股票,,,昨天没买那就是昨日最大值就是0
 * a[i][1] = Math.max(a[i][1],0 - nums[i])
 *
 *
 */
public class Solution3 {


    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int result = solution3.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("result = " + result);
    }
}
