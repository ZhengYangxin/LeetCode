package com.zyx.leetcode.question0003_length_of_longest_sub_string;

/**
 *
 * 哈希法
 *
 * 存储
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int[] hash = new int[128];
        int ans = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            start = Math.max(hash[s.charAt(end)], start);
            ans = Math.max(ans, end - start + 1);
            hash[s.charAt(end)] = end + 1;
        }
        return ans;
    }
}
