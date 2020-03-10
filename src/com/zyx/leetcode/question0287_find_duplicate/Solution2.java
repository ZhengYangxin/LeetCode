package com.zyx.leetcode.question0287_find_duplicate;

/**
 * 二分法
 */
public class Solution2 {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // 说明 重复元素在【1， mid】之间
            if (count > mid) {
                right = mid;
            } else { // 在[mid, right]之间
                left = mid + 1;
            }
        }
        return left;
    }
}
