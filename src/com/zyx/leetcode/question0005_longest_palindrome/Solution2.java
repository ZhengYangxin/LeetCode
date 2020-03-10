package com.zyx.leetcode.question0005_longest_palindrome;

/**
 *
 * 向两边扩展  [i,j] 是回文串， 当 j - i < 2 说明是一个空串，或者只有一个字符串则肯定是回文串
 * dp[i, j]  = dp[i+1, j-1]  && s[i] == s[j]
 *
 */
public class Solution2 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
