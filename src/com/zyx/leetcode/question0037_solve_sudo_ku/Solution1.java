package com.zyx.leetcode.question0037_solve_sudo_ku;

public class Solution1 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];

        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    row[i][num] = true;
                    col[j][num] = true;
                    block[blockIndex][num] = true;

                }
            }
        }

        dfs(board, row, col, block, 0, 0);
    }

    // 深度优先遍历

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        // terminator  当i == 9  j == 9，遍历完所有节点

        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }

            if (i >= 9) {
                return true;
            }
        }

        for (int num = 0; num < 9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !col[i][num] && !block[blockIndex][num]) {
                board[i][j] = (char)(num + '1');
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                boolean result = dfs(board, row, col, block, i, j);
                if (result) {
                    return true;
                } else {
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '.';
                }

            }
        }

        return false;
    }

}
