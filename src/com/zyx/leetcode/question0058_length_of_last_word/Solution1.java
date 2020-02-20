package com.zyx.leetcode.question0058_length_of_last_word;

/**
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户
 * 			内存消耗:41.4 MB,击败了5.19% 的Java用户
 *
 */
public class Solution1 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end <0) return 0;

        int start = end;
        while (start>=0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
