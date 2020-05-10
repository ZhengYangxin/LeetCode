package com.zyx.leetcode.interview0013_moving_count;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 广度优先遍历
 * 往右下方向遍历
 */
public class Solution2 {
    public int movingCount(int m, int n, int k) {

        // 向右和向下的方向数组
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};

        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        deque.add(new int[]{0, 0});
        visited[0][0] = true;
        int ans = 0;
        while (!deque.isEmpty()) {
            int[] pop = deque.pop();
            for (int i = 0; i < 2; i++) {
                int tx = pop[0] + dx[i];
                int ty = pop[1] + dy[i];

                if (tx < 0 || tx >= m || ty < 0 || ty >= n || visited[tx][ty]) {
                    continue;
                }

                if (tx / 10 + tx % 10 + ty / 10 + ty % 10 > k) {
                    continue;
                }
                deque.add(new int[]{tx, ty});
                visited[tx][ty] = true;
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.movingCount(1, 2, 1);
        System.out.println("result = " + result);
    }


}
