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

    public Trie1() {
        this.root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(ch, new TreeNode());
            }
            node = node.get(ch);
        }
        node.setEnd(word);
    }

    public boolean search(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean searchPrefix(String prefix) {
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

}

class TreeNode {

    private int N = 26;
    private TreeNode[] links;
    private boolean end;
    private String word;

    public TreeNode() {
        links = new TreeNode[N];
    }

    public boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TreeNode node) {
        links[ch - 'a'] = node;
    }

    public TreeNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd(String word) {
        end = true;
        this.word = word;
    }

    public boolean isEnd() {
        return end;
    }
}
