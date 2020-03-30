package com.zyx.leetcode.question0055_can_jump;

public class Solution3 {
    public boolean canJump(int[] nums) {
        int maPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > maPosition) return false;
            maPosition = Math.max(maPosition, nums[i] + i);
        }
        return true;
    }
}
