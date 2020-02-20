package com.zyx.leetcode.question0208_trie;

class Trie {

    private TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.contains(currentChar)) {
                node.put(currentChar, new TreeNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd(word);

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
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
        TreeNode node = root;
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

class TreeNode {
    private boolean end;
    private TreeNode[] links;
    private int N = 26;
    private String word;

    public TreeNode() {
        this.links = new TreeNode[N];
    }

    public boolean contains(char key) {
        return links[key - 'a'] != null;
    }

    public TreeNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TreeNode node) {
        links[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(String word) {
        this.end = true;
        this.word = word;
    }

}