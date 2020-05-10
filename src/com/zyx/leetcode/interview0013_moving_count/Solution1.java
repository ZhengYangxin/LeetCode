package com.zyx.leetcode.interview0013_moving_count;

/**
 * 深度优先遍历
 * 往右下方向遍历
 */
public class Solution1 {
    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];

        return dfs(m, n, 0, 0, k, visited);
    }

    public int dfs(int m, int n, int i, int j, int k, boolean[][] visited) {

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return 0;
        }

        if (i / 10 + i % 10 + j / 10 + j % 10 > k) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(m, n, i + 1, j, k, visited) + dfs(m, n, i, j + 1, k, visited) + 1;
    }

    public static void main(String[] args) {
        Solution1 solution2 = new Solution1();
        int result = solution2.movingCount(1, 2, 1);
        System.out.println("result = " + result);
    }
}
