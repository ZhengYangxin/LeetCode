package com.zyx.leetcode.question0190_reserve_bits;

/**
 *
 * 二进制 颠倒
 * 思路
 * 1.  int 为32位
 * 2. 通过新res，得到n的最后一位，添加到res
 */
public class Solution1 {
    public int reverseBits(int n) {
        int count = 0;
        int res = 0;
        while (count < 32) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.reverseBits(6);
        System.out.println("result0 = " + Integer.toBinaryString(6));
        System.out.println("result = " + result);
        System.out.println("result1 = " + Integer.toBinaryString(result));

    }

}
