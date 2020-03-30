package com.zyx.leetcode.question0300_length_of_lis;

/**
 * 动态规划
 *
 * dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
 *
 * 执行耗时:14 ms,击败了58.52% 的Java用户,内存消耗:37.7 MB,击败了5.05% 的Java用户
 *
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        // 输入异常处理
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp 方程定义，及初始化，子序列至少包含自己，所以长度为1
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            // 遍历前面节点的最长子序列长度
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
