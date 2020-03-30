package com.zyx.leetcode.question0010_is_match;

/**
 *
 *
 *
 * 执行耗时:82 ms,击败了22.25% 的Java用户,内存消耗:41.4 MB,击败了7.12% 的Java用户
 *
 */
public class Solution1 {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*' && dp[0][i - 2]) {  // * 可以表示0个元素
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < text.length(); i++) {
            for (int j = 1; j < pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    if (pattern.charAt(j - 2) != text.charAt(i - 1) && pattern.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }
}
