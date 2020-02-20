package com.zyx.leetcode.question0052_total_n_queens;

public class Solution3 {
    private int count;
    public int totalNQueens(int n) {

        boolean[][] col = new boolean[n][n];
        boolean[][] pie = new boolean[n][n];
        boolean[][] na = new boolean[n][n];
        return solve(0, col, pie, na, n);
    }

    private int solve(int row, boolean[][] col, boolean[][] pie, boolean[][] na, int n) {
        if (row == n) {
            count++;
            return count;
        }

        for (int i = 0; i < n; i++) {

        }
        return 0;
    }

}
