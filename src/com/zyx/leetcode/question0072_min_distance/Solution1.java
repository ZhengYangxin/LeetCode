package com.zyx.leetcode.question0072_min_distance;

/**
 *
 * 动态规划
 * 从后往前分析
 *
 * 1. dp[i][j]  i为word1中的字符位置 j为word2中字符的位置
 * 2. dp方程
 *
 * if(word1.charAt(i) == word2.charAt(j))
 * dp[i][j] = dp[i-1][j-1] + 1
 *
 * if(word1.charAt(i) != word2.charAt(j))
 * dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j])
 *
 */
public class Solution1 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m * n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int i = solution1.minDistance("horse", "ros");
        System.out.println("i = " + i);

    }
}
