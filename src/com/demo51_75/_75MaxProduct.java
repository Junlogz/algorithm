package com.demo51_75;

/**
 * @author: JunLog
 * @Description: 152. 乘积最大子数组
 * Date: 2022/8/23 10:35
 */
public class _75MaxProduct {

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    // Time：O(n), Space：O(1)
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = curMax * nums[i], b = curMin * nums[i], c = nums[i];
            curMax = max(a, b, c);
            curMin = min(a, b, c);
            max = Math.max(max, curMax);
        }
        return max;
    }

}
