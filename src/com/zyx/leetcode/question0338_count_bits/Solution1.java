package com.zyx.leetcode.question0338_count_bits;

/**
 *  动态规划
 *  1111
 *  前一个比特位1的数量加一
 *  dp[i] = dp[i& (i-1)] + 1
 *
 *  因为 dp[i & (i - 1)] < dp[i]  所以dp[i & (i - 1)]肯定是事先算好的
 *
 */
public class Solution1 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] result = solution1.countBits(5);
        for (int count : result) {
            System.out.println("count = " + count);
        }
    }
}
