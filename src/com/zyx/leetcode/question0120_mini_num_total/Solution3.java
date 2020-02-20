package com.zyx.leetcode.question0120_mini_num_total;

import java.util.List;

/**
 * 自底向上 动态规划 优化
 *
 * 1. 重复性 （分治）problem(i,j) = min(subproblem(i+1, j), subproblem(i+1, j+1)) + problem(i, j)
 * 2. 定义状态数组 a[i][j]
 * 3. DP方程 a[i][j] = min(a[i+1][j], a[i+1][j+1]) + a[i][j]
 *
 * 在计算过程中只需要下一层的数据，其他层其实并不需要,所以只保存当前层的下一层数据即可
 * int[] dp = new int[triangle.size() + 1]; 长度为triangle.size() + 1
 * 因为在计算过程中，dp[j] = Math.min(dp[j], dp[j+1]) j < triangle.get(i).size() 最大层
 *
 *
 * 执行耗时:4 ms,击败了49.76% 的Java用户，内存消耗:45 MB,击败了5.08% 的Java用户
 */
public class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}
