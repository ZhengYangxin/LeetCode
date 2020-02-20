package com.zyx.leetcode.question0070_climbing_stairs;

/**
 * 基于动态规划实现
 *
 * 当一个问题，可以被分解为包含最优解的子问题时，它的最优解就可以从其子问题的最优解来有效构建
 *
 * 定义状态 dp[i] = dp[i-1][i-2]
 *
 * 时间复杂度O(n)
 *
 * 空间复杂度O(n)
 *
 */
public class Solution2 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 每次可以走0到k步，爬到顶的种数
     *
     * dp[i]  i步的种数
     * 走到i，可以从i - [0..k]  走上来
     *
     * dp[i] = dp[i - dp[k]]
     *
     * @param n
     * @param k
     * @return
     */
    public int climbStairsKStep(int n, int k) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i] += i - dp[j] > 0 ? dp[i - dp[j]] : 0;
            }
        }
        return dp[n];
    }

    /**
     *  相隔步数不相同
     *
     *  dp[i][k] = dp[j][k]
     * @param n
     * @param k
     * @return
     */
    public int climbStairsSetStep(int n, int k){
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n+1][n+1];
        dp[1][k] = 1;
        dp[2][k] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= k; l++) {
//                    dp[i] += i - dp[j] > 0 ? dp[i - dp[j]] : 0;
                }
            }
        }
        return dp[n][n];

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int resultK = solution2.climbStairsKStep(8, 4);
        int result = solution2.climbStairs(8);
        System.out.println("result = " + result);
        System.out.println("resultK = " + resultK);
    }
}
