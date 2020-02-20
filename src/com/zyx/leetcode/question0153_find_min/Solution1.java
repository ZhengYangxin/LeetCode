package com.zyx.leetcode.question0153_find_min;

public class Solution1 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int middle = left;

        while (nums[left] >= nums[right]) {
            if (right - left == 1) {
                return nums[right];
            }
            middle = left + ((right - left) >> 1);
            if (nums[left] < nums[middle]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return nums[middle];
    }
}
