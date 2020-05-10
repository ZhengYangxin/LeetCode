package com.zyx.leetcode.question0992_subarrays_with_k_distinct;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int totalAns = 0, left = 0;
        int count = 1; // 统计窗口中的子数组个数，元素唯一
        for (int i = 0; i < A.length; i++) {
            // map 存储key为元素， value为相同元素的个数
            if (!map.containsKey(A[i])) map.put(A[i], 1);
            else map.put(A[i], map.get(A[i]) + 1);

            // Map保存的不同元素的个数为k时，需要移除坐左边的元素
            if (map.keySet().size() > K) {
                map.remove(A[left]);
                left++;
                count = 1;
            }

            if (map.keySet().size() == K) {
                while (map.get(A[left]) > 1) {
                    map.put(A[left], map.get(A[left]) -1);
                    left++;
                    count++;
                }
                totalAns += count;
            }

        }
        return totalAns;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
        System.out.println("result = " + result);

    }
}
