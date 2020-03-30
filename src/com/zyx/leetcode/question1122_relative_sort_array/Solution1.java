package com.zyx.leetcode.question1122_relative_sort_array;

/**
 *
 * 计数排序
 *
 * temp统计arr1中每个元素出现的次数
 *
 * 遍历arr2， 获取当前元素temp的个数,重置arr1的数据
 */
public class Solution1 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];

        for (int num : arr1) {
            temp[num]++;
        }

        int index = 0;
        for (int n : arr2) {
            while (temp[n]-- > 0) {
                arr1[index++] = n;
            }
        }

        for (int j = 0; j < temp.length; j++) {
            while (temp[j]-- > 0) {
                arr1[index++] = j;
            }
        }
        return arr1;
    }
}
