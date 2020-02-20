package com.zyx.leetcode.question0493_reverse_pairs;

import java.util.Arrays;

public class Solution1 {
    private int ret = 0;
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return 0;
        }

        int mid = begin + ((end - begin) >> 1);
        int count = mergeSort(nums, begin, mid) + mergeSort(nums, mid + 1, end);

        for (int i = begin, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) j++;
            count += j - (mid + 1);
        }

        Arrays.sort(nums, begin, end + 1);
        myMerge(nums, begin, end, mid);
        return count;
    }

    private void myMerge(int[] nums, int begin, int end, int mid) {
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, begin, temp.length);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = new int[]{2, 4, 3, 5, 1};
        int result = solution1.reversePairs(nums);
        System.out.println("result = " + result);
        for (int num : nums) {
            System.out.println("num = " + num);
        }

    }
}
