package com.zyx.leetcode.question0062_unique_paths;

import java.util.Arrays;

/**
 *
 * 动态规划
 *
 * 类似于斐波拉切算法，并不需要存n-1之前所有的结果，只需要i-1和i-2的结果即可
 *
 * 只记录一行的数据即可
 */
public class Solution2 {

    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
