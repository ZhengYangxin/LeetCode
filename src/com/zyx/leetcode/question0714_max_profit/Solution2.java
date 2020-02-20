package com.zyx.leetcode.question0714_max_profit;

/**
 *  对solution1 空间复杂度优化
 *
 *  在计算过程中我们只需要前一个数的数据即可
 */
public class Solution2 {


    public int maxProfit(int[] prices, int fee) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);  // 减手续费放在这，第一次计算可能发生int 溢出
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.maxProfit(new int[]{1,3,2,8,4,9}, 2);
        System.out.println("result = " + result);
    }
}
