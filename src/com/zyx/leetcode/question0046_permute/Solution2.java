package com.zyx.leetcode.question0046_permute;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 *
 *  排列组合
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new LinkedHashSet<>(), nums, res);

        return res;
    }

    private void helper(LinkedHashSet<Integer> integers, int[] nums, List<List<Integer>> res) {
        if (integers.size() == nums.length) {
            res.add(new ArrayList<>(integers));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) continue;
            integers.add(nums[i]);
            helper(integers, nums, res);
            integers.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution2 solution1 = new Solution2();
        List<List<Integer>> permute = solution1.permute(nums);
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
