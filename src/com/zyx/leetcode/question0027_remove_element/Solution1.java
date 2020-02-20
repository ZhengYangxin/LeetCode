package com.zyx.leetcode.question0027_remove_element;

/**
 *
 * 双指针法
 * 思路
 * 定义两个指针慢指针k, 快指针i,遍历数组，当num[i] ！= val 时，num[k++] = num[i]，最后的数组新长度为k
 *
 * 时间复杂度O(n)， 数组大小为n，k，j 至少遍历 2n 步
 * 空间复杂度O(1)
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户,内存消耗:35.4 MB,击败了25.17% 的Java用户
 *
 */
public class Solution1 {
    public int removeElement(int[] nums, int val) {
        int n = 0;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }

        int k = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
