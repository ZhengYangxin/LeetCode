package com.zyx.leetcode.question0322_coin_change;

import java.util.Arrays;

/**
 *
 * 动态规划
 *
 * dp方程 f(n)= min(f(n-k) k(1,2,5)) + 1
 *
 * dp[i] 为i面值所需的最小硬币数
 * dp[i] = min(dp[i - coins[j]]) +1
 */
public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始值为amount +1， 若dp[i]元素未修改则意味着没有找到解
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        int result = solution1.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("result = " + result);
    }

}
