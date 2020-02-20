package com.zyx.leetcode.question0070_climbing_stairs;

/**
 *
 * 对动态规范2解法的优化，因为只需要保存前两个结果的值就可以
 * 可以通过两个变量实现
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution3 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
