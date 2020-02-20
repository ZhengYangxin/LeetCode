package com.zyx.leetcode.question0069_my_sqrt;

/**
 *
 * 牛顿迭代法
 *
 * x(n+1) = x(n) - f(x)/f'(x)  =>  x(n+1) = x(n) + (  x(n) +y/x(n)  )/2
 */
public class Solution2 {
    public int mySqrt(int x) {
        int r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r;
    }
}
