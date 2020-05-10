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

    public void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseWords(char[] chs, int length) {
        int i = 0, j = 0;
        while (i < length) {
            while (i < j || i < length && chs[i] == ' ') {
                i++;
            }

            while (j < i || j < length && chs[j] != ' ') {
                j++;
            }

            reverse(chs, i, j - 1);
        }
    }

    public String cleanSpace(char[] chs) {
        int i = 0, j = 0;
        while (i < chs.length) {
            while (i < chs.length && chs[i] == ' ') i++;
            while (i < chs.length && chs[i] != ' ') chs[j++] = chs[i++];
            while (i <chs.length && chs[i] == ' ') i++;
            if (i < chs.length) {
                chs[j++] = ' ';
            }
        }
        return new String(chs, 0, j);


    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = solution1.reverseWords("hello word!");
        System.out.println("s = " + s);
    }
}
