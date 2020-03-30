package com.zyx.leetcode.question0030_find_sub_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        HashMap<String, Integer> founds = new HashMap<>();

        int num = words.length;
        int len = words[0].length();
        for (int i = 0; i < s.length() - num * len + 1; i++) {
            founds.clear();
            int j = 0;
            for (j = 0; j < num; j++) {
                String sub = s.substring(i + j * len, i + j * len + len);
                if (counts.containsKey(sub)) {
                    founds.put(sub, founds.getOrDefault(sub, 0) + 1);
                    if (founds.get(sub) > counts.getOrDefault(sub, 0)) {
                        break;
                    }
                } else {
                    break;
                }
            }

            if (j == num) {
                res.add(i);
            }
        }

        return res;

    }
}
