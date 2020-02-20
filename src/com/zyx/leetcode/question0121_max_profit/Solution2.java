package com.zyx.leetcode.question0121_max_profit;

/**
 * 卡丹算法 视频50
 * 在一段连续的数组中，找元素的最大差价。两两相减得到差值，最后得到一个一小段的总和，若一直大于0，求最大值，若小于0重制
 *
 *
 * 只有一次交易机会
 *
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxCurrent = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCurrent = Math.max(0, maxCurrent += prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxProfit, maxCurrent);
        }
        return maxProfit;
    }
}
