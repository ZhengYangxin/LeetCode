package com.zyx.leetcode.question1111_max_depth_after_split;

/**
 * 将一个有效括号的字符串分成两个子串，使两个子串的深度尽肯能小
 *
 */
public class Solution1 {
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.length() == 0) {
            return null;
        }
        int[] ans = new int[seq.length()];
        int index = 0;
        for (char c : seq.toCharArray()) {
            ans[index++] = c == '(' ? ((index + 1) & 1) : (index & 1);
        }
        return ans;
    }
}
