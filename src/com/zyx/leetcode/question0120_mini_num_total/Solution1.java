package com.zyx.leetcode.question0120_mini_num_total;

import java.util.List;

/**
 * 暴力法 brute-force
 *
 * 递归实现
 * n层：left right  2^n
 * 每一层，选中当前i的i+1和i+2个元素进行比较，得到较小的值 加上本身的值
 *
 * 1. terminator
 *  level = triangle.size()-1
 *  return triangle.get(level).get(i);
 *
 * 2. logic
 * 选择向下，或者下左
 * int left = mininum(level + 1, i, triangle);
 * int right = mininum(level + 1, i + 1, triangle);
 *
 * return Math.min(left, right) + triangle.get(level).get(i)
 *
 * 3. drill down
 * 进入下层循环 level+1, i
 *
 */
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
//        return mininum(0, 0, triangle);
        int[][] memo = new int[triangle.size()][triangle.size()];
        return mininumUpdate(0, 0, triangle, memo);
    }

    private int mininum(int level, int i, List<List<Integer>> triangle) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(i);
        }
        int left = mininum(level + 1, i, triangle);
        int right = mininum(level + 1, i + 1, triangle);
        return Math.min(left, right) + triangle.get(level).get(i);
    }

    /**
     * 优化
     * 通过增加一个数组memo[leve][i]当前层当前元素的最小值
     *
     * @param level
     * @param i
     * @param triangle
     * @param memo
     * @return
     */
    private int mininumUpdate(int level, int i, List<List<Integer>> triangle, int[][] memo) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(i);
        }

        if (memo[level][i] != 0) {
            return memo[level][i];
        }

        int left = mininum(level + 1, i, triangle);
        int right = mininum(level + 1, i + 1, triangle);
        memo[level][i] = Math.min(left, right) + triangle.get(level).get(i);
        return memo[level][i];
    }

}
