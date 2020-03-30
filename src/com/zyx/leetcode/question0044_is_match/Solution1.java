package com.zyx.leetcode.question0044_is_match;

/**
 *
 * 动态规划
 * dp[i][j], 分别表示s的i长度的字符， p的j长度的字符，是否匹配
 * 当dp[0][0]  表示都为空串，则为true
 *
 * 当 s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'，则
 * dp[i][j] = dp[i-1][j-1]
 *
 * 当 p.charAt(j-1) == '*',则
 * dp[i][j] = dp[i-1][j] || dp[i][j-1]
 * dp[i][j-1]  表示*为空串   ab, ab*
 * dp[i-1][j] 表示*为不空串  abcd, ab*
 *
 *
 */
public class Solution1 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) && p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
