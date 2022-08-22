package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 最小路径和
 * Date: 2022/8/19 11:03
 */
public class _51MinSumOfPath {

    // Time：O(m*n), Space：O(m*n)
    public int minSumOfPath1(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][] d = new int[m][n];

        d[0][0] = a[0][0];
        for (int i = 1; i < m; i++)
            d[i][0] = d[i - 1][0] + a[i][0];
        for (int j = 1; j < n; j++) {
            d[0][j] = d[0][j - 1] + a[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                d[i][j] = Math.min(d[i - 1][j], d[i][j - 1]) + a[i][j];
            }
        }
        return d[m - 1][n - 1];
    }

    // Time：O(m*n), Space：O(n)
    public int minSumOfPath2(int[][] a) {
        int m = a.length, n = a[0].length;
        int[] d = new int[n];

        d[0] = a[0][0];
        for (int j = 1; j < n; j++) {
            d[j] = d[j - 1] + a[0][j];
        }

        for (int i = 1; i < m; i++) {
            d[0] += a[i][0];
            for (int j = 1; j < n; j++) {
                d[j] = Math.min(d[j], d[j - 1]) + a[i][j];
            }
        }

        return d[n - 1];
    }

}
