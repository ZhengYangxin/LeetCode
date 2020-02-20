package com.zyx.leetcode.base_structure;

public class QuickSort {
    public void quickSort(int[] array, int begin, int end) {
        if (begin >= end) return;

        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter]; array[counter] = array[i]; array[i] = temp;
                counter++;
            }
        }
        int temp = array[counter]; array[counter] = array[pivot]; array[pivot] = temp;
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 6, 3, 4, 6};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }
}
