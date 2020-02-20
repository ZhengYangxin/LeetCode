package com.zyx.leetcode.question0063_unique_paths_with_obstacles;

public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        return helper(0, 0, obstacleGrid);

    }

    private int helper(int i, int j, int[][] obstacleGrid) {
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1 && obstacleGrid[i][j] == 0) {
            return 1;
        }

        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }

        return helper(i + 1, j, obstacleGrid) + helper(i, j+1, obstacleGrid);
    }
}
