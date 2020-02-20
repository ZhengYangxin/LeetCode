package com.zyx.leetcode.question0309_max_profit;

/**
 *
 * 动态规划
 * a[i][j] i为天数  j为是否持有股票 的最大值（即最优解）
 *
 * 1无交易次数限制  2 没交易一次需冷冻一天
 *
 * dp方程
 * 当前天未持有股票的最大值，可以从昨天未持有股票，和从天持有股票今天卖出中取最大值
 * a[i][0] = Math.max(a[i-1][0], a[i-1][1]+ prices[i])
 * 当天持有股票，可以从昨天持有股票和 前天没有持有股票今天买入股票中取最大值
 * a[i][1] = Math.max(a[i-1][1], a[i-2][0] - prices[i])
 *
 *
 * 可以优化空间数组的消耗，通过定义三个变量pd_i_0 = a[i][0] = 0, pd_i_1 = a[i][1] = Integer.MIN_VALUE
 * dp_pre = a[i-2][0] = 0
 *
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre = 0; // 表示dp[i-2]
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre - prices[i]);
            dp_pre = temp;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.maxProfit(new int[]{1,2,3,0,2});
        System.out.println("result = " + result);
    }
}
