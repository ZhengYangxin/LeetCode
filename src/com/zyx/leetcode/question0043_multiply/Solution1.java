package com.zyx.leetcode.question0043_multiply;

public class Solution1 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();

        int n1 = chs1.length;
        int n2 = chs2.length;
        int[] res = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j++) {
                int product = (chs1[i] - '0') * (chs2[j] - '0');  // 结果为两位，第一位在res[i+i], 第二位在res[i+j+1]
                int temp = res[i + j + 1] + product;

                res[i + j] = res[i + j] = temp / 10;
                res[i + j + 1] = temp % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }

            sb.append(res[i]);
        }

        return sb.toString();
    }

}
