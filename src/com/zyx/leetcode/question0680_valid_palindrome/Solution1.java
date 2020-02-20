package com.zyx.leetcode.question0680_valid_palindrome;

public class Solution1 {
    public boolean validPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValidPalindrome(s.toCharArray(), i + 1, j) || isValidPalindrome(s.toCharArray(), i, j - 1);
            }
        }
        return true;
    }

    private boolean isValidPalindrome(char[] chs, int i, int j) {
        while (i <= j) {
            if (chs[i++] != chs[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        boolean result = solution1.validPalindrome("aba");
        System.out.println("result = " + result);
    }
}
