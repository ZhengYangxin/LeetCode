package com.zyx.leetcode.question0042_trap;

/**
 * 按列求,动态规划
 *
 * 是对Solution2的优化，在Solution2中，求每列的储水量，都要循环左右两侧最高的墙，比较耗时，
 * 我们完全可以通过数组max_left, max_right保存所需的最大值
 *
 * 待计算的时候直接取出即可
 *
 *
 * 注意
 * 边界墙，不会储水可以排除
 * 时间复杂度为O(n) ：数组的长度
 * 空间复杂度O(n)：用于保存左右最大值的数组
 *
 * 执行耗时:1 ms,击败了99.98% 的Java用户，内存消耗:38.1 MB,击败了12.25% 的Java用户
 *
 *
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution2.trap(heights);
        System.out.println("args = [" + trap + "]");
    }

    public int trap(int[] height) {
        int sum = 0;
        if (null == height || height.length == 0) {
            return sum;
        }

        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);  // 在数组中寻找最大值且max_right 有序
        }

        for (int i = 1; i < height.length - 1; i++) { // 左右边界不能储水无需考虑
            int minValue = Math.min(max_left[i], max_right[i]);

            if (minValue > height[i]) {
                sum += minValue - height[i];
            }
        }

        return sum;
    }
}
