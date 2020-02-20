package com.zyx.leetcode.question0077_combine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * n 为元素范围 [1,n]
 * k 为选出的元素个数
 * 排列组合的结果
 *
 * 优化
 *
 * 回溯法
 * 思路
 * 1. 对于n个元素可以分成n层，现将第一层的元素放入结果，然后在第二层中找加入结果，当结果集的个数=k，则退回上一层，在第三层中找
 *
 * 1. teminator
 * 回溯的条件即递归的结束条件  result.size() == k
 * 加入结果集 results.add(result)
 *
 * 2. logic
 * 当前层的i值，加入集合，在后面层取值加入结果集
 *
 * 3. reverse status
 * remove k的最后一个结果
 *
 */
public class Solution2 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        helper(1, n, k, new ArrayList<Integer>(), results);
        return results;
    }

    private void helper(int start, int n, int k, ArrayList<Integer> result, List<List<Integer>> results) {
        // teminator
        if (k == result.size()) {
            results.add(new ArrayList<>(result));
            return;
        }

        // logic
        int len = (n - result.size()) + 1;  //result.size()为已经保存的数字
        for (int j = start; j < len; j++) {  // 将当前层的值j范围[start, n],将当前层加入结果，再获取下一层的值
            result.add(j);
            // drill down  // 每次所需要加入的值减少即k -1
            helper(j + 1, n, k, result, results);
            // reverse status
            result.remove(result.size() - 1);
        }
    }
}
