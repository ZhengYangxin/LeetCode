package com.zyx.leetcode.question0072_edit_distance;

/**
 *
 * 两个字符串问题
 * 1。 状态数组 dp[i][j]  i 为word1 的字符串位置， j为word2的字符串的位置
 *
 * 2. 状态方程
 *      1. 当word[i] == word[j]
 *      d[i][j] == Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) +1
 *
 *      2. 当word1[i] != word2[i]
 *      d[i][j] == Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
 *
 */
public class Solution1 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {
            return n + m;
        }

        int[][] dp = new int[n + 1][m + 1];

//        if ()
        return 0;
    }
}
