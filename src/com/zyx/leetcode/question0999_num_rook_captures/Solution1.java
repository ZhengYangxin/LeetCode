package com.zyx.leetcode.question0999_num_rook_captures;

public class Solution1 {
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int[][] derections = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    for (int[] derection : derections) {
                        if (search(board, i, j, derection)) {
                            res++;
                        }
                    }
                    return res;
                }
            }
        }
        return res;
    }

    private boolean search(char[][] board, int i, int j, int[] derection) {
        while (inArea(board, i, j)) {

            if (board[i][j] == 'B') {
                break;
            }

            if (board[i][j] == 'p') {
                return true;
            }

            i += derection[0];
            j += derection[1];
        }

        return false;
    }

    private boolean inArea(char[][] board, int i, int j) {
        return (i >= 0 && i < board.length) && (j >= 0 && j < board[0].length);
    }


}
