package com.zyx.leetcode.question0152_max_product;

/**
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户,内存消耗:38.8 MB,击败了16.89% 的Java用户
 *
 */
public class Solution4 {
    public int maxProduct(int[] nums) {
        int max = 1, len = nums.length, product = 1;
        for(int i = 0; i < len; i++) {
            max = Math.max(product *= nums[i], max);
            if (nums[i] == 0) product = 1;
        }

        product = 1;
        for(int i = len - 1; i >= 0; i--) {
            max = Math.max(product *= nums[i], max);
            if (nums[i] == 0) product = 1;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution4 solution1 = new Solution4();
        int result = solution1.maxProduct(new int[]{2,3,-2,4});
        System.out.println("result = " + result);

    }
}
