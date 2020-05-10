package com.zyx.leetcode.question0062_unique_paths;

public class Solution3 {
    public int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1);
    }

    private int helper(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0 || n == 0) {
            return 1;
        }
        return helper(m - 1, n) + helper(m, n - 1);
    }


    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:36.5 MB,击败了5.33% 的Java用户
     *
     * @param m
     * @param n
     * @param memo
     * @return
     */
    private int helperV2(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }

        if (memo[m][n] != 0) {
            return memo[m][n];
        }

        memo[m][n] = helperV2(m - 1, n, memo) + helperV2(m, n - 1, memo);
        return memo[m][n];
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int i = solution3.uniquePaths(3, 2);
        System.out.println("i = " + i);
    }
}
