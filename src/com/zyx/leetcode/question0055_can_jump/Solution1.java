package com.zyx.leetcode.question0055_can_jump;

/**
 * 动态规划
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return true;
        }
        int ennable = nums.length -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= ennable) {
                ennable = i;
            }
        }

        return ennable == 0;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        boolean b = solution1.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println("Solution1.main" + b);

    }
}
