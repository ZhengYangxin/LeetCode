package com.zyx.leetcode.question0378_kth_smallest;

/**
 *
 * 基于二分查找实现
 *
 * 在最大值和最小值中找到符合条件的值
 *
 * int lo = matrix[0][0], hi[matrix.length -1][matrix.length -1]
 *
 * int mid = lo + ((hi - lo) >> 1) 找到中间值
 *
 * 从二维数组的右上角，统计小mid的个数
 *
 * 二维数组右上角元素的特点是，为当前行的最大值，为当前列的最小值
 */
public class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }

            if(count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

}
