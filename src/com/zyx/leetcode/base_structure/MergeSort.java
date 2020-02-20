package com.zyx.leetcode.base_structure;

public class MergeSort {
    public void mergeSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int mid = begin + ((end - begin) >> 1);
        mergeSort(array, begin, mid);
        mergeSort(array, mid + 1, end);

        merge(array, begin, mid, end);
    }

    private void merge(int[] a, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= end) {
            temp[k++] = a[j++];
        }

//        for (int l = 0; l < temp.length; l++) {
//            a[begin + l] = temp[l];
//        }

        System.arraycopy(temp, 0, a, begin, temp.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 6, 3, 4, 6};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }
}
