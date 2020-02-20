package com.zyx.leetcode.question0052_total_n_queens;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int totalNQueens(int n) {
        List<Integer> ans = new ArrayList<>();
        solve(new ArrayList<Integer>(), n, ans);
        return ans.size();
    }

    private void solve(ArrayList<Integer> queens, int n, List<Integer> ans) {
        if (queens.size() == n) {
            ans.add(1);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!queens.contains(col)) {
                if (isAttack(queens, n)) {
                    continue;
                }
                queens.add(col);
                solve(queens, n, ans);
                queens.remove(queens.size() - 1);
            }
        }
    }

    private boolean isAttack(ArrayList<Integer> queens, int n) {
        int currentRow = queens.size();
        int currentCol = n;

        for (int row = 0; row < queens.size(); row++) {
            if (Math.abs(currentRow - row) == Math.abs(currentCol - queens.get(row))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution2 = new Solution1();
        int result = solution2.totalNQueens(4);
        System.out.println("result = " + result);
    }
}
