package com.zyx.leetcode.question0049_group_anagrams;

import java.util.*;


/**
 *
 * 思路和242题，但是需要记录是否每次的字符的唯一值，若相同则归为一类
 *
 * 时间复杂度O(nk)：n为数组长度，k为每个字符串的长度
 * 空间复杂度O(n)：开辟了map用于存储
 *
 * 执行耗时:21 ms,击败了27.09% 的Java用户,内存消耗:43.3 MB,击败了54.56% 的Java用户
 *
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count, 0);
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append("#");
                sb.append(c);
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}
