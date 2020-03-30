package com.zyx.leetcode.question0013_roman_to_int;

/**
 *
 * IV  是4 VI 是 6
 * 当num > preNum  sum = sum - preNum
 * 当num < preNum  sum = sum + preNum
 *
 * 执行耗时:4 ms,击败了99.97% 的Java用户,内存消耗:41.3 MB,击败了5.00% 的Java用户
 *
 */
public class Solution1 {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char charAt) {
        switch (charAt) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
