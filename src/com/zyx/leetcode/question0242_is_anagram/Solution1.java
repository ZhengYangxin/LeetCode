package com.zyx.leetcode.question0242_is_anagram;

/**
 * 判断 s 和t字符串中包含的元素是都相同
 *
 * 1. 首先判断两个字符串是否是等长，不相等则直接返回false
 * 2. 若相等，则初始化26个字母哈希表，遍历s和t
 * 3. s负责在对应位置增加，t负责在对应位置减少
 * 4. 最后遍历哈希表的值，都为零，则二者是字母异或词
 *
 * 思路
 * 时间复杂度O(n)
 * 空间复杂度O(1): 虽然使用了额外空间，但是空间大小是有限的
 *
 * 执行耗时:5 ms,击败了69.40% 的Java用户，内存消耗:36.2 MB,击败了97.86% 的Java用户
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        String s = "abd";
        String t = "dab";
        Solution1 solution1 = new Solution1();
        boolean anagram = solution1.isAnagram(s, t);
        System.out.println("result: " + anagram);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
