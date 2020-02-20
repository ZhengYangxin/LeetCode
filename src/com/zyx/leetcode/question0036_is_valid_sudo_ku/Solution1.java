package com.zyx.leetcode.question0036_is_valid_sudo_ku;

public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        if (null == board || board.length == 0) {
            return false;
        }
        int n = board.length;
        boolean[][] row = new boolean[n][n];
        boolean[][] col = new boolean[n][n];

        boolean[][] block = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j % 3;

                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 'A';
        System.out.println("num = " + num);
    }

}
