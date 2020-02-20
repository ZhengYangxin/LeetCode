package com.zyx.leetcode.question0213_rob_2;

import java.util.Arrays;

/**
 *
 * 动态规划
 *
 * 1. 子问题
 * 2. 状态数组
 * 3. DP方程
 *
 * 1、
 * 偷和被偷的信息需要记录，用于获取前一值的最大值 0没偷， 1偷了
 * 如果当前房间偷了， 那前一个房间就不能偷了，获取不能偷的最大值
 * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1])
 *
 * 若果当前房间偷了，则只需要获取到前一个不投的最大值
 * dp[i][1] = dp[i-1][0] + nums[i]
 *
 * 2. 假设每个房间都偷, 则dp方程 为，比较当前房间的前一个房间和前一个房间+当前房间的最大值
 * nums[i] = Math.max(nums[i-1], nums[i-2] + nums[i])
 *
 *
 * 其中 首尾你不能相连偷
 *
 * 所以只需 去掉第一个房间进行偷， 去掉最后一个房间进行偷，比较两者最大值
 *
 */
public class Solution1 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] copyOfRange) {
        int preMax = 0;
        int currentMax = 0;
        for (int num : copyOfRange) {
            int temp = currentMax;
            currentMax = Math.max(currentMax, preMax + num);
            preMax = temp;
        }
        return currentMax;
    }

}
