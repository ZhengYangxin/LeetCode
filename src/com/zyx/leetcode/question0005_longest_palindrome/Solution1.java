package com.zyx.leetcode.question0005_longest_palindrome;

/**
 *
 * 时间复杂度O(n^2)，由于围绕中心来扩展回文会耗去 O(n)O(n) 的时间
 * 空间复杂度O(1)
 *
 * 执行耗时:33 ms,击败了58.35% 的Java用户
 * 			内存消耗:37.8 MB,击败了28.12% 的Java用户
 */
public class Solution1 {

    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 =  expandAroundCenter(s, i, i + 1); // 偶数情况
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;  // 偶数情况
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

}
