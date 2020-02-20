package com.zyx.leetcode.question0367_isperfect_square;

/**
 *
 * 二分法
 * 执行耗时:0 ms,击败了100.00% 的Java用户，内存消耗:33 MB,击败了51.63% 的Java用户
 *
 */
public class Solution1 {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);

            if (mid * mid == num) {
                return true;
            } else if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        boolean result = solution1.isPerfectSquare(5);
        System.out.println("Solution1.main: " + result);
    }
}
