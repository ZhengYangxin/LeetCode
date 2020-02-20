package com.zyx.leetcode.question0557_reverse_words;

public class Solution1 {
    public String reverseWords(String s) {
        if (null == s || s.isEmpty()) {
            return "";
        }
        char[] chs = s.toCharArray();
        reverseWords(chs, s.length());
        return new String(chs);
    }

    private void reverseWords(char[] chs, int n) {

        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && chs[i] == ' ') i++;
            while (j< i || j < n && chs[j] != ' ') j++;
            reverse(chs, i, j - 1);
        }
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String result = solution1.reverseWords("Let's take LeetCode contest");
        System.out.println("result = " + result);
    }
}
