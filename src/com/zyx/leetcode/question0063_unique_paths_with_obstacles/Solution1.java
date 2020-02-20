package com.zyx.leetcode.question0063_unique_paths_with_obstacles;

/**
 * 动态规划
 *
 * 1. 判断起步是否是有障碍，
 * 2. 将左右边界，不为阻碍物时，且前一个不是阻碍物的设置为1
 * 3. 根据状态方程 opt[i][j] = opt[i-1][j] + opt[i][j-1]
 * 4. 当opt[i][j] == 1，则opt[i][j] = 0，否则 opt[i][j] = opt[i-1][j] + opt[i][j-1]
 * 5. 最后的结果为opt[row-1][col-1]
 *
 */
public class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;
        for (int i = 1; i < row; i++) {
            obstacleGrid[row][0] = obstacleGrid[row][0] == 0 && obstacleGrid[row - 1][0] == 1 ? 1 : 0;
        }

        for (int i = 1; i < col; i++) {
            obstacleGrid[0][col] = obstacleGrid[0][col] == 0 && obstacleGrid[0][col - 1] == 1 ? 1 : 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[row - 1][col - 1];
    }
}
