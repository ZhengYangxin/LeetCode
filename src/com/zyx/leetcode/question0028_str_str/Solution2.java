package com.zyx.leetcode.question0028_str_str;

public class Solution2 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i < n - m; i++) {
            int j = 0;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int resul = solution2.strStr("hello", "ll");
        System.out.println(resul);

    }
}
