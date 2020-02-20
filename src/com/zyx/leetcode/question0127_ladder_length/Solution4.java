package com.zyx.leetcode.question0127_ladder_length;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BFS 广度优先遍历，向外扩散
 */
public class Solution4 {
    public int ladderLength(String beginWord, String endWord, List<String> wordAsList) {
        if(!wordAsList.contains(endWord)) return 0;

        Set<String> wordList = new HashSet<String>(wordAsList);
        Set<String> start = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        int length = 1;
        start.add(beginWord); end.add(endWord);
        wordList.remove(beginWord); wordList.remove(endWord);

        while(!start.isEmpty()){
            Set<String> next = new HashSet<String>();
            for(String word: start){
                char[] wordArray = word.toCharArray();
                for(int i=0; i<word.length(); i++){
                    char old = wordArray[i];
                    for(char c='a'; c<='z'; c++){
                        wordArray[i] = c;
                        String str = String.valueOf(wordArray);
                        if(end.contains(str))
                            return length+1;
                        if(wordList.contains(str)){
                            next.add(str);
                            wordList.remove(str);
                        }
                    }
                    wordArray[i] = old;
                }
            }
            start = next.size() < end.size() ? next: end;
            end = start.size() < end.size() ? end : next;
            length++;
        }
        return 0;
    }
}
