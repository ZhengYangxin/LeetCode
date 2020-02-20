package com.zyx.leetcode.question0208_trie;

public class Trie1 {
    private boolean end;
    private Trie1[] links;
    private static int N = 26;

    /** Initialize your data structure here. */
    public Trie1() {
        links = new Trie1[N];
        end = false;
    }

    private boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    private Trie1 get(char ch) {
        return links[ch - 'a'];
    }

    private void put(char ch, Trie1 node) {
        links[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd() {
        this.end = true;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie1 node = this;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.contains(currentChar)) {
                node.put(currentChar, new Trie1());
            }
            node = node.get(currentChar);
        }
        node.setEnd();

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie1 node = this;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.contains(currentChar)) {
                node = node.get(currentChar);
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie1 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (node.contains(currentChar)) {
                node = node.get(currentChar);
            } else {
                return false;
            }
        }
        return true;
    }
}
