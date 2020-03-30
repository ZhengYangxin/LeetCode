package com.zyx.leetcode.question0057_insert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 执行耗时:2 ms,击败了81.21% 的Java用户, 内存消耗:41.3 MB,击败了48.55% 的Java用户
 */
public class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();

        int index = 0;
        int n = intervals.length;
        // 遍历数组，找到第一个范围大于 插入范围的元素[2,3][6,9][11,15]  [7,10]  找到[6,9]
        while (index < n && newInterval[0] > intervals[index][1]) {
            res.add(intervals[index++]);
        }

        int[] temp = new int[]{newInterval[0], newInterval[1]};

        while (index < n && newInterval[1] >= intervals[index][0]) {
            temp[0] = Math.min(temp[0], intervals[index][0]);
            temp[1] = Math.max(temp[1], intervals[index][1]);
            index++;
        }

        res.add(temp);

        while (index < n) {
            res.add(intervals[index++]);
        }

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
    }
}
