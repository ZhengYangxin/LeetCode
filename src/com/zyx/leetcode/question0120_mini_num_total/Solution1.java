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

    private int mininum(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        int left = mininum(i + 1, j, triangle);
        int right = mininum(i + 1, j + 1, triangle);
        return Math.min(left, right) + triangle.get(i).get(j);
    }

    /**
     * 优化
     * 通过增加一个数组memo[leve][i]当前层当前元素的最小值
     *
     * 执行耗时:1 ms,击败了100.00% 的Java用户,内存消耗:39.3 MB,击败了5.04% 的Java用户
     *
     * @param i
     * @param j
     * @param triangle
     * @param memo
     * @return
     */
    private int mininumUpdate(int i, int j, List<List<Integer>> triangle, int[][] memo) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int left = mininumUpdate(i + 1, j, triangle, memo);
        int right = mininumUpdate(i + 1, j+1, triangle, memo);

        memo[i][j] = Math.min(left, right) + triangle.get(i).get(j);
        return memo[i][j];
    }
}
