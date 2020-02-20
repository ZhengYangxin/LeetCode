package com.zyx.leetcode.question0122_max_profit_2;

/**
 *
 * 动态规划
 *
 * dp[i]若今天肯定没持有
 * dp[i] = max(dp(i-1), dp(i-1)+ price[i])
 *
 *
 * if (nums[i] > dp(i-1))
 *      dp[i] = max(dp(i-1), dp(i-1)+ price[i])
 *  else {
 *
 *  }
 *
 *
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1）
 *
 *
 * 执行耗时:1 ms,击败了99.99% 的Java用户，内存消耗:37.3 MB,击败了46.00% 的Java用户
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int[] dp = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (i - 1 == -1) {
                dp[0] = prices[i];
                continue;
            }
            if (prices[i] > dp[i - 1]) {
                dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i]);
            }
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        int result = solution2.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("result = " + result);

    }
}
