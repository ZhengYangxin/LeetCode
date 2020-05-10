package com.zyx.leetcode.question0200_num_is_lans;

/**
 * 深度优先遍历
 *
 */
public class Solution1 {
    private int[] dx = new int[]{-1, 0, 1, 0};
    private int[] dy = new int[]{0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int numLands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ++numLands;
                    dfs(grid, i, j);
                }
            }
        }
        return numLands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dx[k], j + dy[k]);
        }
    }
}
