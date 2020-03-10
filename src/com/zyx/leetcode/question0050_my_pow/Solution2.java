package com.zyx.leetcode.question0050_my_pow;

/**
 * 迭代法
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 */
public class Solution2 {

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
        double curent = x;

        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * curent;
            }
            curent = curent * curent;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        double v = solution1.myPow(1, Integer.MIN_VALUE);
        System.out.println(v);
    }
}
