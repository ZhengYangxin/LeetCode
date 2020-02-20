package com.zyx.leetcode.question0541_reverse_string;

public class Solution1 {
    public String reverseStr(String s, int k) {
        if (s.isEmpty()) return "";
        char[] a = s.toCharArray();
        for (int j = 0; j < s.length(); j += 2 * k) {
            int i = j, end = Math.min(j + k - 1, s.length() - 1);
            while (i < end) {
                char temp = a[i];
                a[i++] = a[end];
                a[end--] = temp;
            }
        }
        return new String(a);
    }
}
