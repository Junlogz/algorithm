package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 200. 岛屿数量
 * Date: 2022/8/24 14:07
 */
public class _87NumIslands {

    public void dfs(char[][] g, boolean[][] visit, int i, int j) {
        int m = g.length, n = g[0].length;
        if (i < 0 || i > m || j < 0 || j >= n || g[i][j] == '0' || visit[i][j]) return;
        visit[i][j] = true;
        dfs(g, visit, i - 1, j);
        dfs(g, visit, i + 1, j);
        dfs(g, visit, i, j - 1);
        dfs(g, visit, i, j + 1);
    }

    // Time：O(m*n), Space：O(m*n)
    public int numIslands(char[][] g) {
        if (g == null || g.length == 0 || g[0] == null || g[0].length == 0)
            return 0;
        int m = g.length, n = g[0].length;
        boolean[][] visit = new boolean[m][n];

        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '0' || visit[i][j]) continue;
                ++num;
                dfs(g, visit, i, j);
            }
        }
        return num;
    }

}
