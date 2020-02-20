package com.zyx.leetcode.question0917_reverse_only_letters;

public class Solution1 {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.isEmpty()) {
            return S;
        }

        int i = 0, j = S.length() - 1;
        char[] chs = S.toCharArray();
        while (i < j) {
            while (i < j && !Character.isLetter(chs[i])) {
                i++;
            }

            while (i < j && !Character.isLetter(chs[j])) {
                j--;
            }
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String result = solution1.reverseOnlyLetters("ab-cd");
        System.out.println("result = " + result);
    }
}
