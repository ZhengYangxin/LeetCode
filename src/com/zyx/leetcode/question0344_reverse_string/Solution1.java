package com.zyx.leetcode.question0344_reverse_string;

public class Solution1 {
    public void reverseString(char[] s) {
        if (null == s || s.length == 0) {
            return;
        }

        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i]; s[i] = s[j]; s[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        char[] chs = new char[]{'h','e','l','l','o'};
        solution1.reverseString(chs);
        for (char ch : chs) {
            System.out.println("ch = " + ch);
        }
    }

}
