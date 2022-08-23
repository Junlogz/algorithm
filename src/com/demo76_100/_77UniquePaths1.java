package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 63. 不同路径 II
 * Date: 2022/8/23 10:49
 */
public class _77UniquePaths1 {

    // Time：O(m*n), Space：O(m*n)
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] d = new int[m][n];
        d[0][0] = grid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++)
            d[i][0] = grid[i][0] == 1 ? 0 : d[i - 1][0];
        for (int j = 1; j < n; j++)
            d[0][j] = grid[0][j] == 1 ? 0 : d[0][j - 1];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                d[i][j] = grid[i][j] == 1 ? 0 : d[i - 1][j] + d[i][j - 1];
        return d[m - 1][n - 1];
    }

    // Time：O(m*n), Space：O(n)
    public int uniquePaths1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] d = new int[n];
        d[0] = grid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < m; i++){
            d[0] = grid[i][0] == 1 ? 0 : d[0];
            for (int j = 1; j < n; j++) {
                d[j] = grid[i][j] == 1 ? 0 : d[j] + d[j - 1];
            }
        }
        return d[n - 1];
    }

}
