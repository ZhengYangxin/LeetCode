package com.zyx.leetcode.question0042_trap;

/**
 *
 * 按行求
 *
 * 在每行中累加接住的水
 * 1. 获取墙的最大高度，max即需要累加接水量的行数
 * 2. 遍历每一行i行，定义开始接水的变量isStart（在一开始若，行高大于墙的高度是接不到水，需要两面墙相夹才行，当遇到地面 墙高 >= 行高，则可以开始接水），
 *  当前层持续接水总量temp_sum,在两墙间隔多段时，每次累加
 * 3. 当遇到墙高height[j] >= i ,表示可以开始接水，累加上次连续接水的总和sum += temp_sum, 并将temp_sum值为零重新统计，同时isStart = true
 * 4. 当isStart = true，且墙高height[j] < 行高i，开始累加水量temp_sum++
 *
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 *
 * 超时
 */
public class Solution1 {

    public int trap(int[] height) {
        int sum = 0;
        if (null == height || height.length == 0) {  // 第一次解题，遗漏空数组的情况
            return sum;
        }
        int max = getMax(height);

        for (int i = 1; i <= max; i++) {
            int temp_sum = 0;
            boolean isStart = false;

            for (int j = 0; j < height.length; j++) {

                if (isStart && height[i] < i) {
                    temp_sum++;
                }

                if (height[i] >= i) {
                    sum += temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }

        return sum;

    }

    public int getMax(int[] height) {
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }

        return max;
    }
}
