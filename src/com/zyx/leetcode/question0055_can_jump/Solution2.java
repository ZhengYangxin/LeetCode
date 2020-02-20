package com.zyx.leetcode.question0055_can_jump;

/**
 *
 * 基于回溯法
 *
 * 1. teminator
 * position = nums.length -1
 *
 * 2. logic
 * 当前位置可以走的步数
 *
 * 3. drill down
 * 递归下一个位置
 */
public class Solution2 {
    public boolean canJump(int[] nums) {
        return canJupmExt(0, nums);
    }

    private boolean canJupmExt(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(nums[position] + position, nums.length - 1);
//        for (int nextPosition = position + 1; nextPosition < furthestJump; nextPosition++) {
//            if (canJupmExt(nextPosition, nums)) {
//                return true;
//            }
//        }
        // 选择步数最大的去跳跃可以更快
        for (int nextPosition = furthestJump - 1; nextPosition > position; nextPosition++) {
            if (canJupmExt(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }
}
