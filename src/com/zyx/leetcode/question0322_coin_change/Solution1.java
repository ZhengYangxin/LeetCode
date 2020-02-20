package com.zyx.leetcode.question0322_coin_change;

/**
 *
 * 递归
 *
 * 在每次选择一个硬币，得到最小选择数
 *
 * 1. 按层遍历，每一层
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        return helper(coins, amount, new int[amount + 1]);
    }

    private int helper(int[] coins, int rem, int[] count) {
        if (rem == 0) {
            return 0;
        }
        if (rem < 0) {
            return -1;
        }

        if (count[rem] != 0) {
            return count[rem];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper( coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
//
//        if(rem<0) return -1; // not valid
//        if(rem==0) return 0; // completed
//        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
//        int min = Integer.MAX_VALUE;
//        for(int coin : coins) {
//            int res = helper(coins, rem-coin, count);
//            if(res>=0 && res < min)
//                min = 1+res;
//        }
//        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
//        return count[rem-1];

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("result = " + result);
    }

}
