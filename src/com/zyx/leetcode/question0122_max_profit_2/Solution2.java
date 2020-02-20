package com.zyx.leetcode.question0122_max_profit_2;

/**
 *
 * 动态规划
 *
 * dp[i][k][j]   i为天数， k为交易次数， j为是否持有股票j =0 没买， 1 买了
 *
 *
 * 1. 当前没有买入股票
 *  1. 昨天没有买入股票
 *  2. 昨天买入股票，然后今天卖出了股票
 * a[i][0] = Math.max(a[i-1][0], a[i-1][1]+ nums[i])
 *
 * 2. 当前买入了股票
 *  1. 昨天买入了股票
 *  2. 昨天没买股票，今天买入了股票,,,昨天没买那就是昨日最大值就是0
 * a[i][1] = Math.max(a[i-1][1],a[i-1][0] - nums[i])
 *
 *
 * a[-1][0]  表示没有开始交易 则 a[-1][0]=0
 * a[-1][1]  表示没有开始交易，不可能持有则为负无穷
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1）
 *
 *
 * 执行耗时:1 ms,击败了99.99% 的Java用户，内存消耗:37.3 MB,击败了46.00% 的Java用户
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (i - 1 == -1) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("result = " + result);

    }
}
