package com.zyx.leetcode.question0191_hamming_weight;

public class Solution2 {
    public int hammingWeight(int n) {
        int count = 0;
        while ((n & 1) == 1) {
            count++;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.hammingWeight(0xFFFFFFF);
        int result2 = solution2.hammingWeight(0x80000000);
        String s = Integer.toBinaryString(0xFFFFFFFF);
        String s2 = Integer.toBinaryString(3);
        String s3 = Integer.toBinaryString(0x80000000);
        System.out.println("s = " + s);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
        System.out.println(Integer.valueOf(0x80000000));
    }
}
