package com.zyx.leetcode;

/**
 * @author pielan
 * @date 13/12/2019 10:49 下午
 * @dec 在有序数组中去重，并返回去重后的数组长度(remove-duplicates-from-sorted-array)
 * solution:
 * 数组完成排序后，定义两个指针i，j。一个慢指针i，一个快指针j，当nums[i] == nums[j]时，递增j。
 * 当遇到nums[i] != nums[j]时，并将nums[j]的值赋值给nums[i+1], i递增，。继续进行j的递增，去重，知道j到达数组的末尾
 * attention:
 * 当i，j指针位置的元素是相邻，且nums[i] != nums[j],会出现原地，因此可以添加条件j - i > 1
 */
public class Date1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 4, 6, 7, 8, 8, 11};
        int length = removeDuplicates(nums);
        System.out.println(length);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                if (j - i > 1) {
                    nums[i+1] = nums[j];
                }
                i++;
            }
        }
        return i + 1;
    }
}
