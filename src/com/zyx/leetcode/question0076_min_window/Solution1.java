package com.zyx.leetcode.question0076_min_window;

public class Solution1 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = t.length();
        int start = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) count--;

            while (count == 0) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                if (hash[s.charAt(left++)]++ >= 0) {
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String result = solution1.minWindow("a", "aa");
        System.out.println("result = " + result);

    }
}
