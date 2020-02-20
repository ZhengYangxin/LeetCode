package com.zyx.leetcode.question1143_longest_common_sub_sequence;

/**
 *
 * 动态规划
 *
 * 例子
 * input
 * s1 = "";
 * s2 = "A"
 * output = 0
 *
 * input
 * s1 = "A"
 * s2 = "任意"
 * output = 1或者0
 *
 * intput
 * s1 = "A"
 * S2 = "...A"
 * output = 1
 *
 * intput
 * s1 = "...B"
 * S2 = "...A"
 * output = 0+， 可能前面有相同
 * 最后可以变为s1减去末尾的长度与s2进行匹配得到值，或者s2减去末尾的长度和s1进行匹配得到的值,看谁的大
 * 救过就是
 *
 *
 * intput
 * s1 = "...A"
 * S2 = "...A"
 * output = 1+
 * 最后可以变为s1减去末尾的长度，和s2减去末尾的长度进行匹配得到的值+1
 *
 *
 * 将s1 s2 用二维数组存储，s1为列，s2为行
 * dp[i][j] = ?
 * if(s1.charAt(i) == s2.charAt(j)){
 *     dp[i][j] = dp[i-1][j] + dp[i][j-1] + 1
 * } else {
 *     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
 * }
 *
 * 执行耗时:12 ms,击败了23.97% 的Java用户，内存消耗:47.1 MB,击败了5.33% 的Java用户
 *
 *
 *
 */
public class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int col = text1.length();
        int row = text2.length();

        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (text1.charAt(j-1) == text2.charAt(i-1)) {
                    dp[i][j] = dp[i - 1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[row][col];
    }
}
