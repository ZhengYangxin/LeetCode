package com.zyx.leetcode.question0191_hamming_weight;

public class Solution1 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.hammingWeight(0x80000000);
        System.out.println("result = " + result);
    }
}
