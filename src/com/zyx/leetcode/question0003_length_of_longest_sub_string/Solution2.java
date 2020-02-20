package com.zyx.leetcode.question0003_length_of_longest_sub_string;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int[] hash = new int[128];
        int ans = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            left = Math.max(hash[s.charAt(right)], left);
            ans = Math.max(ans, right - left + 1);
            hash[s.charAt(right)] = right++;
        }
        return ans;
    }
}
