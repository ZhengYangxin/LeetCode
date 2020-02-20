package com.zyx.leetcode.question0322_coin_change;

/**
 *
 * 动态规划
 *
 * dp方程 f(n)= min(f(n-k) k(1,2,5)) + 1
 *
 */
public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin]);
                }
            }

            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        int result = solution1.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("result = " + result);
    }

}
