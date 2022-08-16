package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 编辑距离
 * Date: 2022/8/15 23:30
 */
public class _30EditDistance {

    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    // Time:O（m*n） space：O（m*n）
    public int editDistance(String s, String t) {
        if (s == null || t == null) return 0;

        int m = s.length() + 1, n = t.length() + 1;
        int[][] d = new int[m][n];

        for (int i = 0; i < m; ++i)
            d[i][0] = i;
        for (int j = 0; j < n; ++j)
            d[0][j] = j;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = min(d[i - 1][j - 1], d[i - 1][j], d[i][j -1]) + 1;
                }
            }
        }
        return d[m - 1][n - 1];
    }

}
