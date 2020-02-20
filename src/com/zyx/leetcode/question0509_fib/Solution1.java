package com.zyx.leetcode.question0509_fib;

public class Solution1 {
    public int fib(int N) {
        if (N < 2) {
            return N;
        }

        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int fib = solution1.fib(8);
        System.out.println("Solution1.main: " + fib);
    }
}
