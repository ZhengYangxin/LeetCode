package com.zyx.leetcode.base_structure;

public class InsertSort {
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[i];
            while (j >= 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
//            for (j = i; j >= 0 && temp < nums[j - 1]; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] nums = new int[]{1,3,2,1,4,56,3,2};
        insertSort.insertSort(nums);
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }
}
