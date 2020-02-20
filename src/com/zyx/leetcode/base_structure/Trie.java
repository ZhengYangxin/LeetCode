package com.zyx.leetcode.base_structure;

public class Trie {

    private boolean isEnd;

    private char word;

    private Trie[] tries = new Trie[26];

    public Trie() {
        this.isEnd = false;
        this.word = ' ';
    }

    public void insert(String s) {
        char[] chars = s.toCharArray();

        Trie node = this;

        for (int i = 0; i < chars.length; i++) {
            if (node.tries[chars[i] - 'a'] == null) {
                node.tries[chars[i]-'a']=new Trie();
            }
            node = node.tries[chars[i] - 'a'];
            node.word=chars[i];

            if(i==chars.length-1){
                node.isEnd=true;
            }
        }
    }

    public boolean search(String s) {
        char[] chars = s.toCharArray();
        Trie node = this;
        for (int i = 0; i < chars.length; i++) {
            if (node.tries[chars[i] - 'a'] != null) {
                node = node.tries[chars[i] - 'a'];
                if (node.word == chars[i]) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean searchPrefix(String s) {
        char[] chars = s.toCharArray();
        Trie node = this;
        for (int i = 0; i < chars.length; i++) {
            if (node.tries[chars[i] - 'a'] != null) {
                node = node.tries[chars[i] - 'a'];
                if (node.word == chars[i]) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
