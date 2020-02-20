package com.zyx.leetcode.question0169_majority_element;

import java.util.Arrays;

/**
 * 排序法
 *
 * 时间复杂度O(nlgn)
 * 空间复杂度O(1)
 */
public class Solution3 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
