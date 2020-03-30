package com.zyx.leetcode.question0029_divide;

public class Solution1 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;

        long n1 = Math.abs((long) dividend);
        long n2 = Math.abs((long) divisor);

        long resut = 0;
        while (n1 >= n2) {
            int shift = 0;
            while (n1 >= (n2 << shift)) {
                shift++;
            }

            n1 -= n2 << (shift - 1);

            resut += 1 << (shift - 1);
        }

        return flag * (int) resut;

    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.divide(10, 3);

        System.out.println(result);

    }
}

