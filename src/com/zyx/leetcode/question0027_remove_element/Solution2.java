package com.zyx.leetcode.question0027_remove_element;

/**
 *
 * 双指针法, 与尾部交换位置，减少元素移动
 * 思路
 *
 * 上一个解法 当移除元素少的情况，存在2个问题
 * 1. 如[1,2,3,5,6] val =6,  只有最后一个元素需要移除，则前面4个元素都需要赋值操作
 * 2. 如[2,3,4,5,6] val = 2   3,4,5,6元素会进行左移赋值操作
 *
 * 当前解法，当遇到遍历中的元素与val相等时，通过与尾元素交换后，元素长度n-1，避免了不必要的移动，赋值
 *
 * 时间复杂度O(n)： 数组大小为n，k，j 至多遍历 n 步， 赋值操作的次数等于要删除的元素的数量。因此，如果要移除的元素很少，效率会更高。
 * 空间复杂度O(1)
 *
 * 执行耗时:0 ms,击败了100.00% 的Java用户,内存消耗:35.2 MB,击败了62.36% 的Java用户
 *
 *
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{3, 2, 2, 3};
        int result = solution2.removeElement( nums, 3);

        for (int i = 0; i < result; i++) {
            System.out.println("i = " + nums[i]);
        }
    }
    public int removeElement(int[] nums, int val) {
        int n = 0;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }

//        int i = 0;

//        while (i < n) {
//            if (nums[i] == val) {
//                nums[i] = nums[n - 1];
//                n--;
//            } else {
//                i++;
//            }
//        }

        for (int i = 0; i < n; ) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        return n;
    }
}
