package com.zyx.leetcode.question0026_remove_dumplicates;

/**
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * 双指针遍历数组
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了99.98% 的Java用户，内存消耗:40.9 MB,击败了30.60% 的Java用户
 *
 */
public class Solution1 {

    public int removeDuplicates(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
