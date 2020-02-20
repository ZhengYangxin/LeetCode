package com.zyx.leetcode.question0122_max_profit_2;

/**
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1）
 *
 *
 * 执行耗时:1 ms,击败了99.99% 的Java用户，内存消耗:37.3 MB,击败了46.00% 的Java用户
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("result = " + result);

    }
}
