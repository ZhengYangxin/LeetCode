package com.zyx.leetcode.question0509_fib;

public class Solution2 {
    public int fib(int N) {
        if (N < 1) {
            return N;
        }

        int[] memo = new int[N+1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int fib = solution2.fib(8);
        System.out.println("Solution2.main: " + fib);
    }
}
