package com.zyx.leetcode.question0169_majority_element;

/**
 * 投票法
 *
 * count计数器
 * ，当count为0时，选当前遍历数组为众数，当下一个与选中的相同加一，不同减一
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution4 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer cadidate = null;
        for (int num : nums) {
            if (count == 0) {
                cadidate = num;
            }
            count += (num == cadidate) ? 1 : -1;
        }
        return cadidate;
    }
}
