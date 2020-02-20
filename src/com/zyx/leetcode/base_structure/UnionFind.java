package com.zyx.leetcode.base_structure;

/**
 * 并查集
 *
 * 使用场景
 * 组团和配对
 *
 *
 * 默认自己指向自己 parent[i] = i
 *
 * 当发生合并时 一个集合的领头元素，指向另一个的领头元素
 *
 * 搜索哦时，找父元素，直到p = parent[p]
 */
public class UnionFind {

    private int count;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }


    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
