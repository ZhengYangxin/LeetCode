package com.zyx.leetcode.question0054_spiral_order;


import java.util.ArrayList;
import java.util.List;

/**
 * 视频推荐：https://www.bilibili.com/video/BV1vE41167Cr?from=search&seid=12169142994821225844
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:37.5 MB,击败了5.65% 的Java用户
 *
 *
 */
public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        int row = 0, col = 0, dre = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[row][col]);
            int nRow = row + dx[dre];
            int nCol = col + dy[dre];

            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol]) {
                row = nRow;
                col = nCol;
            } else {
                dre = (dre + 1) % 4;
                row += dx[dre];
                col += dy[dre];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<Integer> integers = solution1.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
    }

}
