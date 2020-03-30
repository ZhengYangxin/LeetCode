package com.zyx.leetcode.question0053_max_sub_array;

/**
 * 动态规划
 *
 * 执行耗时:1 ms,击败了97.60% 的Java用户,内存消耗:42.4 MB,击败了5.02% 的Java用户
 * 保存上一个结果就可以
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = current;
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(current, 0) + nums[i];
            max = Math.max(current, max);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println("result = " + result);

    }
}
