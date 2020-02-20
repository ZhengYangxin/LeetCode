package com.zyx.leetcode.question0771_num_jewel;

/**
 *
 *
 * 执行耗时:1 ms,击败了99.89% 的Java用户
 * 			内存消耗:41.7 MB,击败了5.02% 的Java用户
 *
 */
public class Solution2 {
    public int numJewelsInStones(String J, String S) {
        char[] map = new char[256];
        for (char ch : J.toCharArray()) {
            map[ch]++;
        }
        int result = 0;

        for (char c : S.toCharArray()) {

            if (map[c] > 0) {
                result += map[c];
            }
        }
        return result;
    }
}
