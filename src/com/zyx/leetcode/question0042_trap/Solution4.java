package com.zyx.leetcode.question0042_trap;

/**
 * 按列求,双指针法
 *
 * 是对Solution3空间的优化，在Solution3中，会通过数组保存最大墙，而且用到的是其中最大的max_x[i]元素，其他的是不需要的
 * 所以只需要一个变量用于更新它的最大值即可
 *
 * 1. 需要两个指针用于表示左右墙的最大值的位置left， right，及左右最大值，max_left,max_right
 * 2. 当height[left - 1] < height[right + 1]时，意味着，左边墙可以再次寻找一个大一点的墙，即max_left = Math.max(max_left, height[left -1]);
 * 3. 同理右侧也是一样，然后处理储水量后移动指针
 * 注意
 * 边界墙，不会储水可以排除
 * 时间复杂度为O(n) ：数组的长度
 * 空间复杂度O(1)：用于保存左右最大值的数组
 *
 * 执行耗时:1 ms,击败了99.98% 的Java用户，内存消耗:37 MB,击败了92.81% 的Java用户
 *
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution2 = new Solution4();
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution2.trap(heights);
        System.out.println("args = [" + trap + "]");
    }

    public int trap(int[] height) {
        int sum = 0;
        if (null == height || height.length == 0) {
            return sum;
        }

        int max_left = 0;
        int max_right = 0;

        int left = 1;
        int right = height.length - 2;

        for (int i = 1; i < height.length - 1; i++) { // 左右边界不能储水无需考虑

            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);

                int min = max_left;

                if (min > height[left]) {
                    sum += min - height[left];
                }

                left++;
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum += min - height[right];
                }

                right--;
            }

        }

        return sum;
    }
}
