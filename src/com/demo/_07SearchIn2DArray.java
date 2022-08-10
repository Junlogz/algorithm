package com.demo;

/**
 * @author: JunLog
 * @Description: 剑指 Offer 04. 行列递增的二维数组搜索
 * Date: 2022/8/9 10:55
 */
public class _07SearchIn2DArray {

    public int[] searchIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
        || matrix[0] == null || matrix[0].length == 0)
            return new int[]{-1, -1};
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n -1;
        while (i < m && j >= 0) {
            if (target < matrix[i][j]) --j;
            else if (target > matrix[i][j]) ++i;
            else return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }

}
