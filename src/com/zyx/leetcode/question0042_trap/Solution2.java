package com.zyx.leetcode.question0042_trap;

/**
 * 按列求
 *
 * 1. 遍历每一列，找到cur 左右两边最大的列left,right
 * 2. 得到左右两端较小一端的值，
 * 3. 若minValue >cur 的高度，则temp = height[minValue] - height[cur] 值则为当前列的储水量
 *
 * 注意
 * 边界墙，不会储水可以排除
 * 时间复杂度为O(n^2)
 * 空间复杂度O(1)
 *
 * 执行耗时:180 ms,击败了5.16% 的Java用户,内存消耗:37.8 MB,击败了36.91% 的Java用户
 *
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] heights = new int[]{6};
        int trap = solution2.trap(heights);
        System.out.println("args = [" + trap + "]");
    }

    public int trap(int[] height) {
        int sum = 0;
        if (null == height || height.length == 0) {
            return sum;
        }

        for (int i = 1; i < height.length - 1; i++) {

            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }

            int maxRight = 0;

            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            int minValue = Math.min(maxLeft, maxRight);

            if (minValue > height[i]) {
                sum += minValue - height[i];
            }
        }

        return sum;
    }
}
