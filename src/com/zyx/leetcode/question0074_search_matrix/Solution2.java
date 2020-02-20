package com.zyx.leetcode.question0074_search_matrix;

public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int len = row * col;

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (matrix[mid / row][mid % row] == target) {
                return true;
            } else if (matrix[mid / row][mid % row] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
