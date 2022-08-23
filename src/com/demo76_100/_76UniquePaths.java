package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 剑指 Offer II 098. 路径的数目
 * Date: 2022/8/23 10:49
 */
public class _76UniquePaths {

    // Time：O(m*n), Space：O(m*n)
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) return 0;
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++)
            d[i][0] = 1;
        for (int j = 0; j < n; j++) {
            d[0][j] = 1;
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                d[i][j] = d[i - 1][j] + d[i][j - 1];
        return d[m - 1][n - 1];
    }

    public int uniquePaths1(int m, int n) {
        if (m < 1 || n < 1) return 0;
        int[] d = new int[n];

        for (int j = 0; j < n; j++) {
            d[j] = 1;
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                d[j] = d[j] + d[j - 1];
        return d[n - 1];
    }

}
