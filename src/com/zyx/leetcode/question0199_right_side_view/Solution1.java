package com.zyx.leetcode.question0199_right_side_view;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    int useLevel = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root, 0, ans);
        return ans;
    }

    public void solve(TreeNode root, int level, List<Integer> ans) {
        if(root == null) return;
        if (level > useLevel) {
            useLevel = level;
            ans.add(root.val);
        }
        solve(root.right, level + 1, ans);
        solve(root.left, level + 1, ans);
    }
}