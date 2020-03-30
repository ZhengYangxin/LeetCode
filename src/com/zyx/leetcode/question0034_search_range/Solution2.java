package com.zyx.leetcode.question0034_search_range;

/**
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
 */
public class Solution2 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int num1 = getRangeleft(nums, target);
        int num2 = getRangeRight(nums, target);
        return new int[]{num1, num2};
    }

    private int getRangeleft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int mid = left + ((right - left) >> 1);
            if (target == nums[mid] || nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int getRangeRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid] || nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] result = solution2.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

}
