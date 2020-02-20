package com.zyx.leetcode.question0438_find_anagrams;

import java.util.List;

public class Solution2 {

    public List<Integer> findAnagrams(String s, String p) {

        int i = 0, j = 0, count = p.length();
        while (j < s.length()) {

        }
        return null;
    }

    public boolean isValidAnagram(String a, String b) {

        char[] chs = new char[26];

        for (int i = 0; i < a.length(); i++) {
            chs[a.charAt(i) - 'a']++;
            chs[b.charAt(i) - 'a']--;
        }

        for (char ch : chs) {
            if (chs[ch] > 0) {
                return false;
            }
        }
        return true;
    }
}
