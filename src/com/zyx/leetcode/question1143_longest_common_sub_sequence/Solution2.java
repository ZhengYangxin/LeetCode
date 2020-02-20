package com.zyx.leetcode.question1143_longest_common_sub_sequence;

/**
 *
 * 回溯
 *
 * 从后往前继续逻辑判断
 */
public class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1.length() - 1, text1.length() - 1, text1, text2);
    }

    private int helper(int i, int j, String text1, String text2) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (i >= 0 && j >= 0 && text1.charAt(i) == text2.charAt(j)) {
            return helper(i - 1, j - 1, text1, text2) + 1;
        }

        return Math.max(helper(i-1, j, text1, text2), helper(i, j-1, text1, text2));
    }
}
