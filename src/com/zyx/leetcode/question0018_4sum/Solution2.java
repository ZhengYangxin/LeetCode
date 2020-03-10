package com.zyx.leetcode.question0018_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return listList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {   //这个判断很重要，不然会很慢
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 1] > target) {   //这个判断很重要，不然会很慢
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else {
                        listList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[--right]) ;
                        while (left < right && nums[left] == nums[++left]) ;
                    }
                }
            }
        }
        return listList;
    }
}
