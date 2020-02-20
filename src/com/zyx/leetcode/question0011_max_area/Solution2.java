package com.zyx.leetcode.question0011_max_area;

/**
 * 双指针法
 *
 * 思路
 * 1. 数组首尾各一个指针左i，右j，
 * 2. 获取元素高度比较大小，当i<j 且height[i] <height[j]则i++,否则j--;
 * 3. 得到较小的高度进行面积计算，更新maxArea;
 *
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        if (null == height || height.length == 0) {
            return maxArea;
        }

        for (int i = 0, j = height.length - 1; i < j;) {
//            int minHeight = Math.min(height[i], height[j]);
//            int area = (j - i) * minHeight;
//            maxArea = Math.max(maxArea, area);
//
//            if (height[i] > height[j]) {
//                j--;
//            } else {
//                i++;
//            }
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight; // 上一步做了自减/增操作
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
