package com.zyx.leetcode.question0455_find_content_children;

import java.util.Arrays;

/**
 *
 * 孩子的胃大小， 饼干的尺寸大小
 *
 * 饼干应该尽可能的刚好满足孩子
 *
 * 现将两者排序， 双指针执行胃和饼干
 * 当胃girl 被饼干size满足时girl++，size++，下一个小孩和饼干
 * 否则 girl不变，下一个饼干
 *
 * 贪心算法：能满足尽量满足
 *
 *
 * 执行耗时:10 ms,击败了98.32% 的Java用户，内存消耗:40.6 MB,击败了5.12% 的Java用户
 */
public class Solution1 {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int girl = 0;
        int size = 0;
        while (girl < g.length && size < s.length) {
            if (g[girl] <= s[size]) {
                girl++;
            }
            size++;
        }
        return girl;
    }
}
