package com.zyx.leetcode.question0007_reverse;

/**
 *
 * 执行耗时:1 ms,击败了100.00% 的Java用户,内存消耗:36.9 MB,击败了5.01% 的Java用户
 *
 */
public class Solution1 {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) ? 0 : (int) ans;
    }

    /**
     *
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            }

            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
        }

        return ans;
    }
}
