package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 矩阵置零
 * Date: 2022/8/18 11:23
 */
public class _50SetZeroInMatrix {

    // Time:O（m*n） space：O（m+n）
    public void setZeroInMatrix1(int[][] a) {
        int m = a.length, n = a[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0)
                    rows[i] = cols[j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j])
                   a[i][j] = 0;
            }
        }

    }

    // Time:O（m*n） space：O（1）
    public void setZeroInMatrix2(int[][] a) {
        int m = a.length, n = a[0].length;
        boolean row0 = false, col0 = false;

        for (int i = 0; i < m; i++) {
            if (a[i][0] == 0) col0 = true;
        }
        for (int j = 0; j < n; j++) {
            if (a[0][j] == 0) row0 = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 0)
                    a[i][0] = a[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][0] == 0 || a[0][j] == 0)
                    a[i][j] = 0;
            }
        }

        if (row0)
            for (int j = 0; j < n; j++)
                a[0][j] = 0;
        if (col0)
            for (int i = 0; i < m; i++)
                a[i][0] = 0;
    }

}
