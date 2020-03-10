package com.zyx.leetcode.question0050_my_pow;

/**
 *  每次将n变成一半，
 *
 *
 *  时间复杂度O(logn)
 *
 *  空间复杂度O(logn)： 每次需要保持一半的结果，栈帧
 *
 *
 *  执行耗时:1 ms,击败了99.93% 的Java用户,内存消耗:34 MB,击败了15.06% 的Java用户
 *
 */
public class Solution1 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long a = n;
        if (a < 0) {
            x = 1 / x;
            a = -a;   // 当n = -2^31时，进行取反会越界，所以单位需要是long
        }
        return fastPow(x, a);

    }

    private double fastPow(double x, long n) {
        // teminator
        if (n == 0) {   // x^0 = 1
            return 1.0;
        }

        // logic and drill down
        double half = fastPow(x, n >> 1);

        // merge
        if ((n & 1) == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        double v = solution1.myPow(1, -2147483648);
        System.out.println(v);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}
