package com.zyx.leetcode.question0387_first_uniq_char;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 执行耗时:1243 ms,击败了5.09% 的Java用户
 * 			内存消耗:47.8 MB,击败了5.05% 的Java用户
 *
 */
public class Solution1 {
    public int firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
