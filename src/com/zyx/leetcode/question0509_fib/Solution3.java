package com.zyx.leetcode.question0509_fib;

public class Solution3 {

    public int fib(int N) {
        if (N < 2) {
            return N;
        }

        int a = 0, b = 1, c = 3;

        for (int i = 2; i <= N; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int fib = solution3.fib(8);
        System.out.println("Solution3.main: " + fib);
    }
}
