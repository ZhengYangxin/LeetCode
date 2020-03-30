package com.zyx.leetcode.question0010_is_match;

/**
 *
 * dp[i][j]  i,j 分别表示text，pattern的长度
 *
 * 当两者长度都为0是，则dp[0][0] = true
 *
 * 当patter为空是，dp[i][0]都为 false
 *
 * 当text为空时， 即dp[0][j] 则需要看情况
 * text ""
 * pattern "a*"
 * 为true
 *
 *
 * 执行耗时:149 ms,击败了7.16% 的Java用户,内存消耗:42.1 MB,击败了5.05% 的Java用户
 *
 *
 */
public class Solution2 {
    public boolean isMatch(String text, String pattern) {

        boolean[][] dp = new boolean[text.length() + 1][text.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < text.length(); i++) {
            for (int j = 1; j < pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    if (pattern.charAt(j - 2) != text.charAt(i) && pattern.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }
}
