package com.zyx.leetcode.question0014_longest_common_prefix;

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
        return strs[0];
    }
}
