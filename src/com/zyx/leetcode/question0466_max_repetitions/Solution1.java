package com.zyx.leetcode.question0466_max_repetitions;

public class Solution1 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;
        while(count1 < n1) {
            if (chs1[i] == chs2[j]) {
                j++;
                if (j == chs2.length) {
                    j = 0; 
                    count2++;
                }
            } 
            i++;
            if (i == chs1.length) {
                i = 0;
                count1++;
            }
        }

        return count2 / n2;
    }
}