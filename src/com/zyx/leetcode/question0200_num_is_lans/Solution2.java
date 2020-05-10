package com.zyx.leetcode.question0200_num_is_lans;

public class Solution2 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uFind = new UnionFind(grid);
        int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x>=0 && x < n && y >=0 && y< m && grid[x][y] == '1') {
                            uFind.union(i * m + j, x * m + y);
                        }
                    }

                    // if(i > 0 && grid[i-1][j] == '1') {
                    //     uFind.union(i * m + j, (i-1) * m + j);
                    // }

                    // if(i < n-1 && grid[i+1][j] == '1') {
                    //     uFind.union(i * m + j, (i+1) * m + j);
                    // }

                    // if(j > 0 && grid[i][j-1] == '1') {
                    //     uFind.union(i * m + j, i * m + (j-1));
                    // }

                    // if(j < m-1 && grid[i][j + 1] == '1') {
                    //     uFind.union(i * m + j, i * m + (j+1));
                    // }
                }
            }
        }
        return uFind.count;
    }

}

class UnionFind {
    int count;
    int[] parent;
    int[] size;

    public UnionFind(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        parent = new int[n*m];
        size = new int[n*m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    parent[i * m + j] = i * m + j;
                    count ++;
                    size[i]  = 1;
                }
            }
        }
    }

    public int find(int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ) {
            return;
        }

        if(size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count --;
    }
}