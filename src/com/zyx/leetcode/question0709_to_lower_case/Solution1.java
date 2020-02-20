package com.zyx.leetcode.question0709_to_lower_case;

public class Solution1 {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] - 'A' + 'a');
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println('a' + 0);
        System.out.println('A' + 0);

        Solution1 solution1 = new Solution1();
        String result = solution1.toLowerCase("Hello");
        System.out.println("result = " + result);
    }
}
