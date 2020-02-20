package com.zyx.leetcode.question0011_max_area;

/**
 * 暴力法
 * 遍历左右边界
 */
public class Solution1 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        if (null == height || height.length == 0) {
            return maxArea;
        }

        for (int i = 0; i < height.length - 1; i++) {
            for (int i1 = i + 1; i1 < height.length; i1++) {
//                int minHeight = height[i] > height[i1] ? height[i1] : height[i];
                int minHeight = Math.min(height[i], height[i1]);
                int area = (i1 - i) * minHeight;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
