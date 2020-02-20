package com.zyx.leetcode.question0231_is_power_of_two;

/**
 *
 * -n =   ~n + 1  获取二进制中最右边的 1   当n为2的幂次时只有一个最高位的1，所以当 n & (-n)  == n
 */
public class Solution2 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (-n)) == n;
    }
}
