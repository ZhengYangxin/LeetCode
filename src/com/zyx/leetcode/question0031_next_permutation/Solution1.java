package com.zyx.leetcode.question0031_next_permutation;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * 题意可以理解为，一个整数，通过排列组合得到下一个最大整数，若已经是做大整数，则返回最小值
 * 123 -> 132 -> (231)213 -> 231 -> (321)312 -> 321
 * 321 -> 123
 *
 * 思路
 * 1. 从后往前寻找第一对，相邻递增的元素[k, k+1]
 * 2. 从后往前找到第一个大于num[k]的元素 num[j], 交换两者的位置， 并对[k+1, n-1]进行升序
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了99.97% 的Java用户，内存消耗:39 MB,击败了21.68% 的Java用户
 *
 *
 *
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = new int[]{1, 5,1};
        solution1.nextPermutation(nums);
        for (int num : nums) {
            System.out.println("num = " + num);
        }

    }

    public void nextPermutation(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) < 2) {
            return;
        }

        int k = n - 2;  // 第一次结题，"="遗漏
        while (k >= 0 && nums[k + 1] <= nums[k]) { // 从后往前寻找第一对递增相邻元素nums[k] <= nums[k+1]
            k--;
        }

        if (k >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[k] >= nums[j]) { // 从后往前寻找第一个大于递增元素nums[k]的元素
                j--;
            }

            swap(nums, k, k+1);
        }

        reserve(nums, k + 1); // 对 [k+1, n-1]的元素进行递增排序
    }

    private void reserve(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int k, int j) {
        int temp = nums[k];
        nums[k] = nums[j];
        nums[j] = temp;
    }

}
