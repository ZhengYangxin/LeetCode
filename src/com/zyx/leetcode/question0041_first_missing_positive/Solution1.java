package com.zyx.leetcode.question0041_first_missing_positive;

/**
 * 桶排序
 *
 *  a 数组每个位置都存着比下标大 1 的数
 * [-1,3,2,4]  [-1,2,3,4]
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了99.22% 的Java用户，内存消耗:34.4 MB,击败了98.79% 的Java用户
 *
 */
public class Solution1 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
