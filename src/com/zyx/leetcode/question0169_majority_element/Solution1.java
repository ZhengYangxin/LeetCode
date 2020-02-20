package com.zyx.leetcode.question0169_majority_element;

/**
 * 暴力法
 * 遍历数组，对每次遍历的元素在遍历数组记录元素个数
 *
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 *
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (i == num) {
                    count++;
                }
            }

            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }
}
