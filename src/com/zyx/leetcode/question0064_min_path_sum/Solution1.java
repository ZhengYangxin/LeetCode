package com.zyx.leetcode.question0064_min_path_sum;

/**
 *
 * 很明显是一个求最优解的题，最优解可以从子问题中构建而成
 * 用动态规划来解决问题
 *
 * 1. 子问题（分治） problems[i,j] = Math.min(subProblem(i, j+1), subProblem(i+1, j))
 * 2. 定义状态数组 dp[i][j]
 * 3. dp方程 dp[i,j] = Math.min(dp(i, j+1), dp(i+1, j)) + dp[i][j]
 */
public class Solution1 {

    public int minPathSum(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row == 0 && col != 0) {
                    grid[row][col] = grid[row][col - 1] + grid[row][col];
                } else if (col == 0 && row == 0) {
                    grid[row][col] = grid[row - 1][col] + grid[row][col];
                } else if (row != 0 && col != 0) {
                    grid[row][col] = Math.min(grid[row][col - 1], grid[row - 1][col]) + grid[row][col];
                }
            }
        }
        return grid[n - 1][m - 1];
    }
}
