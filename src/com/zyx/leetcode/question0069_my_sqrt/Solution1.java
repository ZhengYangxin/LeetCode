package com.zyx.leetcode.question0069_my_sqrt;

/**
 * 二分法
 *
 * 一个数的a的平方根b，b在[0, a]的有序范围内，那b*b如果大于a，则平方根的值在b的左边即小于b，否则大于b
 *
 * y = x^2  x>0 单调递增
 *
 * 在返回值上，取最接近x的值，所以ans =  left -1
 *
 * 执行耗时:2 ms,击败了84.17% 的Java用户,内存消耗:33.7 MB,击败了22.73% 的Java用户
 *
 */
public class Solution1 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;

        // 终止条件是left > right
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid > x / mid) {
                right = mid - 1;
                //  因为我们要找的ans要是最接近于x的最大的数，利用upper bound
            } else {
                left = mid + 1;
            }
        }
        return left -1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.mySqrt(8);
        System.out.println("Solution1.main: " + result);
    }

}
