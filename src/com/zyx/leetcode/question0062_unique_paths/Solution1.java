package com.zyx.leetcode.question0062_unique_paths;

/**
 *
 * 动态规划
 *
 * 状态的定义 int[] dp = new dp[m][n], dp[i][j]
 * 状态转换方程 dp[i][j] = dp[i+1, j] + dp[i, j+1]
 *
 */
public class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
