package com.zyx.leetcode.interview0051_reverse_pairs;

public class Solution1 {
    public int reversePairs(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return 0;
        }

        int mid = begin + ((end - begin) >> 1);

        int count = mergeSort(nums, begin, mid)+ mergeSort(nums, mid + 1, end);

        for (int i = begin, j = mid + 1; i <= mid; i++) {
            while (j<= end && nums[i] > nums[j]) j++;
            count += j - (mid + 1);
        }

        merge(nums, begin, mid, end);

        return count;
    }

    private void merge(int[] nums, int begin, int mid, int end) {
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
        int[] nums = new int[]{7,5,6,4};
        Solution1 solution1 = new Solution1();
        int result = solution1.reversePairs(nums);
        System.out.println("result = " + result);
    }
}
