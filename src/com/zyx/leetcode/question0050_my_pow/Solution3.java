package com.zyx.leetcode.question0050_my_pow;

/**
 * 迭代法
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 执行耗时:1 ms,击败了98.34% 的Java用户,内存消耗:37.2 MB,击败了5.03% 的Java用户
 */
public class Solution3 {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        long a = n;  // int最小值越界
        if (a < 0) {
            x = 1 / x;
            a = -a;
        }

        double ans = 1.0;   // 返回值double类型
        while (a != 0) {
            if ((a & 1) == 1) {
                ans *= x;
            }
            x *= x;
            a >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution1 = new Solution3();
        double v = solution1.myPow(1, Integer.MIN_VALUE);
        System.out.println(v);
    }
}
