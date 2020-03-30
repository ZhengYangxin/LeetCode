package com.zyx.leetcode.question0028_str_str;

/**
 * https://www.bilibili.com/video/av11866460/?spm_id_from=333.788.videocard.0
 */
public class Solution1 {

    public int[] prefixTable(String pattern) {
        int[] prefix = new int[pattern.length() + 1];

        int len = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = len;
                    i++;
                }

            }
        }

        System.arraycopy(prefix, 0, prefix, 1, prefix.length - 1);
        prefix[0] = -1;
        return prefix;
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        int[] prefixTable = prefixTable(needle);

        int n = haystack.length();
        int m = needle.length();
        int i = 0;
        int j = 0;
        while (i < n) {
            if (j == m - 1 && haystack.charAt(i) == needle.charAt(j)) {
                return i - j;
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = prefixTable[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.strStr("hello", "ll");

        System.out.println("result = " + result);

    }
}
