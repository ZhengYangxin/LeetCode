package com.zyx.leetcode.question0152_max_product;

/**
 *
 * 递归
 *
 * 每个元素有两种选择，选择相乘，不选择相乘。
 * 每次得到两种结果的最大值，记录
 * 选择相乘，则继续将相乘的结果传入的下一个元素
 * 不选择相乘的，则将当前元素传入到下一个元素
 *
 * 1. terminator
 *  当i== nums.length 元素个数为递归的层级
 *
 * 2. logic
 * 处理当前层的最大值, 以及传入下一层的数据
 *
 * 3. drill down
 * 递归下一层
 *
 * 4. reverse status
 */
public class Solution2 {

    int max = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        helper(nums, 1, 0);
        return max;
    }

    private void helper(int[] nums, int product, int i) {
        if (i == nums.length) {
            return;
        }

        int select = nums[i] * product;
        int max_value = Math.max(product, select);
        max = Math.max(max_value, max);

        helper(nums, nums[i], i + 1);
        helper(nums, select, i + 1);

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.maxProduct(new int[]{2,3,-2,4});
        System.out.println("result = " + result);
    }
}
