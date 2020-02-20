package com.zyx.leetcode.question0074_search_matrix;

/**
 *
 * 找规律
 *
 * 从左上角开始搜索
 *
 * 若matrix[row][col] < target ,则按列从上往下寻找col++
 * 若matrix[row][col] < target, 层按行往左寻找row--
 *
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
    }
}
