package com.zyx.leetcode.question0047_permute2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);

        solve(nums, new ArrayDeque<Integer>(), res, visited);
        return res;
    }

    public void solve(int[] nums, ArrayDeque<Integer> path, List<List<Integer>> res, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;


            // 排序后进行去重
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;


            visited[i] = true;
            path.addLast(nums[i]);
            solve(nums, path, res, visited);
            visited[i] = false;
            path.removeLast();
        }
    }
}
