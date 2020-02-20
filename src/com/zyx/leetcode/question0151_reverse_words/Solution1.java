package com.zyx.leetcode.question0151_reverse_words;

public class Solution1 {
    public String reverseWords(String s) {
        if (null == s || s.isEmpty()) {
            return "";
        }
        char[] chs = s.toCharArray();
        reverse(chs, 0, chs.length - 1);
        reverseWords(chs, chs.length);
        return cleanSpace(chs);
    }

    public void reverse(char[] a, int i, int j) {
        char[] chs = a;
        for (; i < j; i++, j--) {
            char temp = chs[i]; chs[i] = chs[j]; chs[j] = temp;
        }
    }

    public void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') {
                i++;
            }
            while (j < i || j < n && a[j] != ' ') {
                j++;
            }
            reverse(a, i, j - 1);
        }
    }

    public String cleanSpace(char[] chs) {
        int len = chs.length;
//        while (st < len && chs[st] == ' ') {
//            st++;
//        }
//
//        while (st < len && chs[len - 1] == ' ') {
//            len--;
//        }
//        return new String(chs, st, len);

        int i = 0, j = 0;
        while (j < len) {
            while (j<len && chs[j] == ' ') j++;
            while (j <len && chs[j] != ' ') chs[i++] = chs[j++];
            while (j<len && chs[j] == ' ') j++;
            if (j< len) chs[i++] = ' ';
        }

        return new String(chs, 0, i);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = solution1.reverseWords("hello word!");
        System.out.println("s = " + s);
    }
}
