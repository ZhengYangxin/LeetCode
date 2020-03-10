package com.zyx.leetcode.question0217_contains_duplicate;

import java.util.Arrays;

/**
 *
 * 通过对原数组排序，修改了原数组的相对顺序
 * 排序后的数组若出现重复元素则，前后两个数字为相同的
 * 时间复杂度为O(nlogn) 快速排序
 * 空间复杂度为O(nlogn)
 *
 * 执行耗时:4 ms,击败了98.52% 的Java用户，内存消耗:45.1 MB,击败了5.09% 的Java用户
 */
public class Solution1 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
