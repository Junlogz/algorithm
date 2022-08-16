package com.demo26_50;

/**
 * @author: JunLog
 * @Description: 二分搜索
 * Date: 2022/8/16 11:22
 */
public class _38BinarySearch2DArray {

    // Time:O（log(n)） space：O（1）
    public int[] binarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new int[]{-1,-1};

        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int r = mid / n, c = mid % n;
            if (target < matrix[r][c]) high = mid - 1;
            else if (target > matrix[r][c]) low = mid + 1;
            else return new int[]{r,c};
        }
        return new int[]{-1,-1};
    }

}
