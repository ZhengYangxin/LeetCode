package com.zyx.leetcode.question0120_mini_num_total;

import java.util.List;

/**
 * 自底向上 动态规划
 *
 * 1. 重复性 （分治）problem(i,j) = min(subproblem(i+1, j), subproblem(i+1, j+1)) + problem(i, j)
 * 2. 定义状态数组 a[i][j]
 * 3. DP方程 a[i][j] = min(a[i+1][j], a[i+1][j+1]) + a[i][j]
 *
 *
 * 执行耗时:9 ms,击败了11.33% 的Java用户,内存消耗:39.3 MB,击败了5.04% 的Java用户
 *
 *
 */
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int num = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, num);
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        solution2.minimumTotal()
    }
}
