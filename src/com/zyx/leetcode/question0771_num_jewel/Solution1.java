package com.zyx.leetcode.question0771_num_jewel;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 * 执行耗时:2 ms,击败了52.16% 的Java用户
 * 			内存消耗:41.6 MB,击败了5.02% 的Java用户
 */
public class Solution1 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            characterSet.add(J.charAt(i));
        }

        int ans = 0;
        for (int j = 0; j < S.length(); j++) {
            if (characterSet.contains(S.charAt(j))) {
                ans++;
            }
        }
        return ans;
    }

}
