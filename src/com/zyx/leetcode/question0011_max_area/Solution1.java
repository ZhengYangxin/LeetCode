package com.zyx.leetcode.question0011_max_area;

/**
 * 暴力法
 * 遍历左右边界
 */
public class Solution1 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int lowHeight = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, (j - i) * lowHeight);
            }
        }
        return maxArea;
    }
}
