package com.zyx.leetcode.question0014_longest_common_prefix;

/**
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:3 ms,击败了19.81% 的Java用户，内存消耗:37.6 MB,击败了39.70% 的Java用户
 *
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String word = strs[0];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || word.charAt(i) != strs[j].charAt(i)) {
                    return word.substring(0, i);
                }
            }
        }
        return word;
    }
}
