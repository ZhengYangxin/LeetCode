package com.zyx.leetcode.question0052_total_n_queens;

/**
 *
 * 二进制，通过位移解
 *
 * 假设是4皇后，col， pie，na都是int值
 * 他们的四位二进制 比如 1010  1表示已经有皇后了，不可以放，0表示可以放
 * 得到可以放的二进制 bits = (col|pie|na)  结果中0为可以放的位置，进行取反
 * bits = ~(col|pie|na)  得到的二进制中，1为可以放的位置，但会得到高位也是1
 * bits = ~(col|pie|na) &(1 << n -1)  消除n前面的高位1，
 * 相当于二进制的size =》 (1 << n -1) 当n =4  28位 1111...1011   10000-1=》01111
 * 1111...1011 & 0000...1111   => 0000.... 1011
 * 最后bits的值中，1表示可以放皇后
 *
 * 循环bits找到最低位的1进行递归，并消除低位1
 * int p = bits & -bit  得到最低位的1
 * solve(row + 1, col | p, (ld | p) << 1, (rd | p) >> 1); 当前行最低位的1放入皇后，更新行，及列撇，呐的值
 * bits = bits & (bits - 1)  消除最低位的1
 */
public class Solution2 {
    private int size;
    private int count;

    private void solve(int row, int col, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }

        int bits = (~(col | ld | rd)) & (1 << size - 1);

        while (bits != 0) {
            int p = bits & -bits;
            solve(row + 1, col | p, (ld | p) << 1, (rd | p) >> 1);
            bits = bits & (bits - 1);
        }
    }

    public int totalNQueens(int n) {
        count = 0;
        size = n;
        solve(0, 0, 0, 0);
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.totalNQueens(4);
        System.out.println("result = " + result);
    }
}
