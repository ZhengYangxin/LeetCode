package com.zyx.leetcode.question0438_find_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 滑动窗口算法思路
 * 1. 在字符串S中使用双指针中的左右指针技巧，初始化left = right = 0 把索引闭区间[left, right]称为一个窗口
 * 2. 我们先不断地增加right指针扩大窗口[left, right], 直到窗口中的字符串符合要求
 * 3. 此时我们停止增加right，转而不断增加left指针缩小窗口[left, right]，
 * 直到窗口中的字符串不符合要求，同时每次增加left，更新结果
 *
 * 4. 重复2，3步骤，直到right到达字符串S的尽头
 *
 */
public class Solution3 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (pMap.containsKey(c) && sMap.get(c) <= pMap.get(c)) {
                count++;
            }

            if (count == p.length()) {
                list.add(left);
            }

            if (right - left == p.length()) {
                char leftChar = s.charAt(left);
                if(pMap.containsKey(leftChar) && sMap.get(leftChar) <= pMap.get(leftChar)){
                    count--;
                }
                sMap.put(leftChar, sMap.getOrDefault(leftChar, 1) - 1);
                left++;
            }
        }
        return list;
    }
}
