package com.zyx.leetcode.question0050_my_pow;

/**
 * 迭代法
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 */
public class Solution3 {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;
        while (N != 0) {
            if ((N & 1) == 1) {
                ans *= x;
            }
            x *= x;
            N >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution1 = new Solution3();
        double v = solution1.myPow(2, 2);
        System.out.println(v);
    }
}
