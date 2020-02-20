package com.zyx.leetcode.question0438_find_anagrams;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }

        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++) - 'a']-- >= 1) count--;

            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length() && hash[s.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<Integer> result = solution1.findAnagrams("cbcababacd", "abc");
        for (Integer integer : result) {
            System.out.println("result = " + integer);
        }
    }

}
