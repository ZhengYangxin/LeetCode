package com.zyx.leetcode.question0169_majority_element;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer before = map.getOrDefault(num, 0);
            if (before == nums.length / 2) {
                return num;
            }
            map.put(num, before + 1);
        }

        return -1;
    }
}
