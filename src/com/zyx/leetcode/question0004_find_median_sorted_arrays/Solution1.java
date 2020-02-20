package com.zyx.leetcode.question0004_find_median_sorted_arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 思考
 * 通过两个指针遍历两个数组得到，第k个数和k-1的元素
 *
 * 时间复杂度O(（m+n >> 1 )+1)：两个数组的长度, 需要遍历（len >> 1 )+1次 len = m+n
 * 空间复杂度O(1)
 *
 * 执行耗时:4 ms,击败了37.16% 的Java用户，内存消耗:46.6 MB,击败了53.09% 的Java用户
 */
public class Solution1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2;

        int i = 0, j = 0, index = 0, cur = -1, pre = -1;
        while (index < (n >> 1) + 1) {
            pre = cur;
            if (i < n1 && j < n2) {
                if (nums1[i] < nums2[j]) {
                    cur = nums1[i++];
                } else {
                    cur = nums2[j++];
                }
            } else if (i >= n1 && j < n2) {
                cur = nums2[j++];
            } else if (i < n1 && j >= n2) {
                cur = nums1[i++];
            }

            index++;
        }

        if ((n & 1) == 0) {
            return (pre + cur) * 0.5;
        }

        return cur;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        double result = solution1.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println("result = " + result);
    }
}
