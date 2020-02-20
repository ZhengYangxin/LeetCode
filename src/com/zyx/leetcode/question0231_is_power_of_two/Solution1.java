package com.zyx.leetcode.question0231_is_power_of_two;

/**
 *  2的幂次，则n>0
 *
 *  去除右边第一个1，如果n为2的幂次，则只有最高位的1，则最后 (n & (n - 1)) == 0
 *
 *
 *  取模最后是否等于0
 *
 */
public class Solution1 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
