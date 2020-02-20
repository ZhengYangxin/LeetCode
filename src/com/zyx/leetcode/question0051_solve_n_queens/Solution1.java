package com.zyx.leetcode.question0051_solve_n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 深度遍历
 *
 * 1. 定义queen集合记录皇后在每行的位置
 *
 * teminator
 * 皇后的个数 currentQueen.size() == n
 *
 * logic
 * 在每一行中找到皇后应该在的索引位置
 * 判断当前点是否在集合中，否则判断是否符合条件后加入皇后集合
 * if (!currentQueen.contains(col))
 *
 *  if (isAttack(currentQueen, col)) {
 *         continue;
 *  }
 *  currentQueen.add(col);
 *
 * drill down
 * solve(currentQueen, n, res);
 * 进入下一行
 *
 * reverse status
 * currentQueen.remove(currentQueen.size() - 1);
 * 恢复
 */
public class Solution1 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solve(new ArrayList<Integer>(), n, res);
        return res;
    }

    private void solve(ArrayList<Integer> currentQueen,int n, List<List<String>> res) {
        if (currentQueen.size() == n) {
            res.add(generateResult(currentQueen, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!currentQueen.contains(col)) {
                if (isAttack(currentQueen, col)) {
                    continue;
                }

                currentQueen.add(col);
                solve(currentQueen, n, res);
                currentQueen.remove(currentQueen.size() - 1);

            }
        }

    }

    private boolean isAttack(ArrayList<Integer> currentQueen, int col) {
        int currentRow = currentQueen.size();
        int currentCol = col;
        for (int row = 0; row < currentQueen.size(); row++) {
            if (Math.abs(currentRow - row) == Math.abs(currentCol - currentQueen.get(row))) {
                return true;
            }
        }
        return false;
    }


    private List<String> generateResult(ArrayList<Integer> result, int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] a = new char[n];
            Arrays.fill(a, '.');
            Integer integer = result.get(i);
            a[integer] = 'Q';
            temp.add(new String(a));
        }
        return temp;
    }

}
