package com.zyx.leetcode.question0387_first_uniq_char;

/**
 *
 *
 * 执行耗时:14 ms,击败了69.09% 的Java用户,内存消耗:46.2 MB,击败了5.05% 的Java用户
 *
 */
public class Solution2 {

    public int firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }

        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
