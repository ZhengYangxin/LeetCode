package com.zyx.leetcode.question0153_find_min;

public class Solution2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= right) {
                return nums[left];
            }

            int mid = left + ((right - left) >> 1);

            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}
