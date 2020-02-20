package com.zyx.leetcode.question0058_length_of_last_word;

/**
 *
 * 执行耗时:1 ms,击败了42.58% 的Java用户
 * 			内存消耗:41.4 MB,击败了5.19% 的Java用户
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        String[] words = s.split(" ");
        if (words.length == 0) {
            return 0;
        }

        return words[words.length - 1].length();
    }
}
