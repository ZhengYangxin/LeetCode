package com.zyx.leetcode.question0039_combination_sum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        dfs(candidates, target, 0, res, new ArrayDeque<Integer>());
        return res;
    }

    private void dfs(int[] candidates, int target, int level, List<List<Integer>> res, ArrayDeque<Integer> data) {
        if (target == 0) {
            res.add(new ArrayList<>(data));
        }

        for (int i = level; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }

            data.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, res, data);
            data.removeLast();
        }
    }
}
