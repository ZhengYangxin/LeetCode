package com.zyx.leetcode.question0300_length_of_lis;


/**
 *
 * 贪心 + 二分查找
 *
 * 将最长子序列用数组存起来,维护最长子序列
 * 每添加一个元素比较是否大于数组中的所有元素，是则直接加在尾部，增加子序列长度len+1
 * 否则，找到大于当前元素的第一个元素，并进行替换，len不变
 *
 * 维护子序列数组用的是二分查找
 *
 * 时间复杂度O(nlogn)
 * 空间复杂度O(n)
 *
 * 执行耗时:1 ms,击败了94.83% 的Java用户,内存消耗:37.6 MB,击败了5.05% 的Java用户
 *
 */
public class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        // 定义子序列的数组
        int[] dp = new int[nums.length];
        // 初始化子序列的长度
        int len = 0;
        for (int num : nums) {
            //  二分查找
            int left = 0, right = len;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] > num) {
                    right = mid;
                } else if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 若没有找到合适的替换元素即当前元素大于所有元素
            if (left == len) len++;

            // 替换
            dp[left] = num;
        }

        return len;
    }
}
