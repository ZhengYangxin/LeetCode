package com.zyx.leetcode.question0046_permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 全排列组合
 *
 * 回溯法
 *
 * 1. 按照一层一层的思想
 * 2. 先固定第i个， 然后遍历所有元素与此元素进行交换，知道i == nums.length
 * 3. 回溯，清除上一次交换
 */
public class Solution1 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
//        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
//        for (int num : nums) {
//            nums_lst.add(num);
//        }
        helper(0, nums, results);
        return results;
    }

    private void helper(int begin, int[] nums, List<List<Integer>> results) {
        if (begin == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums) {
                result.add(num);
            }
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums, i, begin);
            helper(begin+1, nums, results);
            swap(nums, i, begin);
        }

//        for (int i = begin; i < nums.length; i++) {
//            swap(nums, i, begin);
//            helper(begin + 1, nums, results);
//            swap(nums, i, begin);
//        }
    }

    private void swap(int[] nums, int i, int begin) {
        int temp = nums[i];
        nums[i] = nums[begin];
        nums[begin] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2,3};
        Solution1 solution1 = new Solution1();
        List<List<Integer>> permute = solution1.permute(nums);
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
}
