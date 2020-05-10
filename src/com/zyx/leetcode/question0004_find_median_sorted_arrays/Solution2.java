package com.zyx.leetcode.question0004_find_median_sorted_arrays;

/**
 * 通过二分法递归实现
 * 1. 寻找第k个数，即中位数，每次排除k/2个元素
 * 2. 在每个数组各自范围内，将数组分为两部分
 * int i = Math.min(n1, k / 2), j = Math.min(n2, k / 2); // 防止left1 + i ，left2 + j发生越界
 * 将数组nums1在[left1, right1]范围内分为两部分， [left1,left1 +i-1] 和 [left1 +i-1, right1]
 * 将数组nums2在[left2, right2]范围内分为两部分， [left2,left2 +i-1] 和 [left2 +i-1, right2]
 * 3. 比较左部分最大值，小的数组左部分被丢弃，同时k的个数减去移除的个数
 * 4. 直到一个数组为0或者k为1
 *
 * 时间复杂度O(log(n1+n2)/2)：其中n1是nums1数组的长度，n2是nums2数组的长度。
 * 空间复杂度O(1)
 *
 * 执行耗时:3 ms,击败了98.34% 的Java用户,内存消耗:47.1 MB,击败了28.88% 的Java用户
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] nums1 = new int[]{1,7};
        int[] nums2 = new int[]{1,2,3,4,5,6,7,8,9};

        double result = solution2.findMedianSortedArrays(nums1, nums2);

        System.out.println(result);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2, target = (n >> 1) + 1;
        int mid1 = findKthInTwoArrays(nums1, 0, n1 - 1, nums2, 0, n2 - 1, target);
        if ((n & 1) == 1) {
            return mid1;
        }

        int mid2 = findKthInTwoArrays(nums1, 0, n1 - 1, nums2, 0, n2 - 1, target - 1);
        return (mid1 + mid2) * 0.5;
    }

    /**
     * 在nums1数组[left1, right1]范围内，以及nums2数组[left2, right2]范围内，寻找第k小数（k从1开始计数）
     */
    private int findKthInTwoArrays(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        int n1 = right1 - left1 + 1, n2 = right2 - left2 + 1;
        // 二分查找过程中，若其中一个数组已经排除，则在另一个数组中。可以优先定义那个数组为长数组方便操作
        if (n1 > n2) {
            return findKthInTwoArrays(nums2, left2, right2, nums1, left1, right1, k);
        }

        if (n1 == 0) {
            return nums2[left2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }

        int i = Math.min(n1, k / 2), j = Math.min(n2, k / 2);

        if (nums1[left1 + i - 1] > nums2[left2 + j - 1]) {
            return findKthInTwoArrays(nums1, left1, right1, nums2, left2 + j, right2, k - j);
        }

        return findKthInTwoArrays(nums1, left1 + i, right1, nums2, left2, right2, k - i);
    }


}
