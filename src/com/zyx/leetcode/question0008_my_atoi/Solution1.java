package com.zyx.leetcode.question0008_my_atoi;

public class Solution1 {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;

        // 1.emptyStr
        if (str.isEmpty()) return 0;

        // 2.remove space
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }

        // 3. handle sign
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }


            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;

        }

        return total * sign;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.myAtoi("2147483646");
        System.out.println("result = " + result);
    }
}
