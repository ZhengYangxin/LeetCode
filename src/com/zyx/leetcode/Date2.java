package com.zyx.leetcode;

/**
 * @author pielan
 * @date 14/12/2019 11:50 下午
 * @dec 当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
 * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
 *
 */
public class Date2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 4, 6, 7, 8, 8, 11};
        rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
