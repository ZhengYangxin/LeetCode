package com.zyx.leetcode.base_structure;

/**
 * 字典树
 * 类似于树，但有不同
 * 1. 每个节点没有完整的字符串
 * 2. 到根节点的路径组成的单词就是一个完整的单词
 * 3. 每个节点的所有子节点都代表着不同的字符串
 *
 * 用空间换时间
 * 利用字符串的公共前缀来降低查询时间的开心以达到提高效率的目的
 *
 */
class Trie1 {

    private TreeNode root;

    /** Initialize your data structure here. */
    public Trie1() {
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