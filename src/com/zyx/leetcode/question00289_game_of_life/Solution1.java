package com.zyx.leetcode.question00289_game_of_life;

/**
 *
 * https://leetcode-cn.com/problems/game-of-life/solution/si-lu-jian-dan-yi-dong-zhu-xing-jie-shi-by-jerry_n/
 */
public class Solution1 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int n = board.length;
        int m = board.length;

        int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = new int[]{0, 0, -1, 1, -1, -1, 1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 拿到当前位置周围活细胞数量
                int count = countOfActive(i, j, n, m, dx, dy, board);
                // 1. 活细胞周围八个位置有两个或三个活细胞，下一轮继续活
                if (board[i][j] == 1 && (count ==2 || count ==3)) board[i][j] = 3;
                // 2. 死细胞周围有三个活细胞，下一轮复活了
                if (board[i][j] == 0 && count ==3) board[i][j] = 2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countOfActive(int i, int j, int n, int m, int[] dx, int[] dy, int[][] board) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            // 如果这个位置为 0，代表当前轮是死的，不需要算进去
            // 如果这个位置为 1，代表当前轮是活得，需要算进去
            // 如果这个位置为 2，代表当前轮是死的（状态10，下一轮是活的），不需要算进去
            // 如果这个位置为 3，代表是当前轮是活的（状态11，下一轮也是活的），需要算进去
            count += (board[i][j] & 1);
        }
        return count;
    }
}
