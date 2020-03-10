package com.zyx.leetcode.question0152_max_product;

/**
 *
 * 动态规划
 *
 * 1.定义动态方程
 * 因为负数的最小值* 当前为负数的值，可能就是最大值
 * 整数的最大值* 当前为正数的值，可能就是最大值
 *
 * dp[i][j]  , i 表示数组0到n选择当前元素i，j 为 0表示最小负数， j为1表示最大整数
 *
 * dp[i][0] 保存最小负数，Math.min(dp[i-1][1]* nums[i], Math.min(dp[i-1][0]* nums[i], nums[i]))
 * dp[i][1] 保存最大整数，Math.max(dp[i-1][0] * nums[i], Math.min(dp[i-1][0]* nums[i], nums[i]))
 *
 * 最后的最大值保存在 dp[i][1]的数组中，i = 【0，n-1】
 *
 */
public class Solution3 {

    /**
     *
     * 执行耗时:4 ms,击败了17.09% 的Java用户,内存消耗:38.8 MB,击败了16.83% 的Java用户
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] * nums[i], Math.min(dp[i - 1][0] * nums[i], nums[i]));
            dp[i][1] = Math.max(dp[i - 1][1] * nums[i], Math.max(dp[i - 1][0] * nums[i], nums[i]));
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }

    /**
     * 优化版本 执行耗时:2 ms,击败了91.59% 的Java用户，内存消耗:38.4 MB,击败了17.42% 的Java用户
     * 去掉不必要的数组空间
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int curMin = nums[0];
        int curMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = curMin;
            curMin = Math.min(curMax * nums[i], Math.min(curMin * nums[i], nums[i]));
            curMax = Math.max(curMax * nums[i], Math.max(temp * nums[i], nums[i]));
            max = Math.max(max, curMax);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int curMin = nums[0];
        int curMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = curMin;
                curMin = curMax;
                curMax = temp;
            }
            curMin = Math.min(curMin * nums[i],nums[i]);
            curMax = Math.max(curMax * nums[i], nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution1 = new Solution3();
        int result = solution1.maxProduct2(new int[]{0,2});
        System.out.println("result = " + result);

    }
}
