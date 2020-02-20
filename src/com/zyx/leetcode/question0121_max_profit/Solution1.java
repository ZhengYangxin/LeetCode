package com.zyx.leetcode.question0121_max_profit;

/**
 *
 * 思路
 * 用于选出那两天的股价相减得到的值最大
 *
 * 1.首先要选出股价最低的一天的价格
 * 2. 通过当天股价与最低价相减得到最大值，更新最大利润
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了99.99% 的Java用户
 * 			内存消耗:37.2 MB,击败了67.15% 的Java用户
 *
 *
 *
 * 	dp[i][k][j]   i为交易的天， k交易次数， j为1，0 是否持有股票
 *
 * 	dp[i][k][j]
 * 	没有持有股票
 * 	dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 *  我昨天没有持有股票，然后今天保持rest, 所以今天还是没有持有
 *  我昨天持有股票，今天选择sell， 所以今天我没有持有股票
 *
 *  持有股票
 *  dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *  我昨天持有股票，然后今天保持rest。所以今天依旧持有
 *  我昨天没有持有，然后今天买入buy，所以今天持有
 *
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
        }
        return maxProfit;
    }
}
