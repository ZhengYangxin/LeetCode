package com.zyx.leetcode.question0045_jump;

public class Solution1 {
    public int jump(int[] nums) {
        int count = 0;

        int lastP = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastP) {
                count++;
                lastP = i;
            }
        }
        return count;
    }
}
