package com.zyx.leetcode.question0051_solve_n_queens;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        solve(board, 0, res);
        return res;
    }

    private void solve(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            res.add(generateResult(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (valide(board, row, i)) {
                board[row][i] = 'Q';
                solve(board, row + 1, res);
                board[row][i] = '.';
            }
        }

    }

    private boolean valide(char[][] board, int row, int col) {
        int currentRow = row;
        int currentCol = col;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'Q' && (Math.abs(currentRow - i) == Math.abs(currentCol - j) || col == j))
                    return false;
            }
        }
        return true;
    }

    private List<String> generateResult(char[][] board) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            temp.add(s);
        }
        return temp;
    }
}
