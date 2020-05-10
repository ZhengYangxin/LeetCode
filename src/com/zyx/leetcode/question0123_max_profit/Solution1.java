package com.zyx.leetcode.question0123_max_profit;

import com.zyx.leetcode.question0122_max_profit_2.Solution2;

/**
 *
 * 动态规划
 *
 * dp[i][k][j]  i 天数， k交易次数， j是否持有股票
 *
 * // 前一天未持有股票，前一天持有股票但今天卖掉了
 * dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 *
 * dp[i][k][1] =  Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int num = 2;
        int[][][] dp = new int[prices.length][num + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int k = num; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][num][0];
    }



    public static void main(String[] args) {
        Solution1 solution2 = new Solution1();
        int result = solution2.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println("result = " + result);
    }



}
