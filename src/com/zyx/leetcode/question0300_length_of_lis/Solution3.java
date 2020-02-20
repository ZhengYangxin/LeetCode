package com.zyx.leetcode.question0300_length_of_lis;

public class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {

            //  二分查找
            int left = 0, right = len;
            while (left < left) {
                int mid = (left + right) / 2;
                if (dp[mid] > num) {
                    right = mid;
                } else if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == len) len++;

            dp[left] = num;
        }

        return len;
    }
}
