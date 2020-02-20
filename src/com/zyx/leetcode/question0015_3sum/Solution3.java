package com.zyx.leetcode.question0015_3sum;


import java.util.*;

/**
 * 哈希法
 * 思路
 * 1. 将元素存入map中，并记录同元素的个数
 * 2. 判断0元素是否>=3, 有则加入结果列表
 * 3. 将map中的key进行排序，得到有序的无重复的元素列表
 * 4. 进行双循环条件判断
 *
 * 时间复杂度是O(n^2), 空间复杂度是O(n)
 * 执行耗时:190 ms,击败了12.73% 的Java用户,内存消耗:49.2 MB,击败了9.76% 的Java用户
 */
public class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        if (map.containsKey(0) && map.get(0) >= 3) {
            appendToList(0, 0, 0, res);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) * 2 + list.get(j) == 0 && map.get(list.get(i)) >= 2) {
                    appendToList(list.get(i), list.get(i), list.get(j), res);
                }
                if (list.get(i) + list.get(j) * 2 == 0 && map.get(list.get(j)) >= 2) {
                    appendToList(list.get(i), list.get(j), list.get(j), res);
                }

                int num = - list.get(i) - list.get(j);
                if (num > list.get(j) && map.containsKey(num)) {
                    appendToList(list.get(i), list.get(j), num, res);
                }
            }
        }

        return res;
    }

    private void appendToList(int k, int i, int j, List<List<Integer>> res) {
        List<Integer> data = new ArrayList<>();
        data.add(k);
        data.add(i);
        data.add(j);
    }
}
