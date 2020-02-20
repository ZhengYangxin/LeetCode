package com.zyx.leetcode.question0034_search_range;

/**
 *
 * 二分查找
 *
 * 思路
 * 在有序数组中找到符合条件的值，递归减少索引找到最小相同值索引，递增找到最大相同值索引
 *
 * 时间复杂度O(logn)
 * 空间复杂度O(1)
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:40.6 MB,击败了62.51% 的Java用户
 *
 */
public class Solution1 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (null == nums || nums.length == 0) {
            return result;
        }

        int index1 = innerSearch(nums, target, true);


        // 当返回值为数组长度意味着没有找到值，
        if (index1 == nums.length || nums[index1] != target) {
            return result;
        }

        result[0] = index1;
        result[1] = innerSearch(nums, target, false) - 1;

        return result;
    }

    private int innerSearch(int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = (end - start) / 2 + start;

            if (target < nums[mid] ||(left && target == nums[mid])) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;

    }
}
