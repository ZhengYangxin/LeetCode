package com.zyx.leetcode.question0547_find_circle_num;

public class Solution2 {
    private int[] dx = new int[]{-1, 0, 1, 0};
    private int[] dy = new int[]{0, -1, 0, 1};

    public int findCircleNum(int[][] M) {
        int n;
        if (M == null || (n = M.length) == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    dfs(M, i, j);
                    ans++;
                }
            }

        }
        return ans;
    }

    public void dfs(int[][] M, int i, int j) {
        if (i < 0 || i >= M.length || j < 0 || j >= M[0].length) {
            return;
        }

        if (M[i][j] == 1) {
            M[i][j] = 0;
            for (int k = 0; k < 4; k++) {
                dfs(M, dx[k] + i, dy[k] + j);
            }
        }

    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        int result = solution1.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println("result = " + result);
    }
}
