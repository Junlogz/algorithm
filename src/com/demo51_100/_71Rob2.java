package com.demo51_100;

/**
 * @author: JunLog
 * @Description: 213. 打家劫舍 II
 * Date: 2022/8/22 14:21
 */
public class _71Rob2 {

    public int rob01(int[] nums, int start, int end) {
        int pre2 = 0, pre1 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    // Time：O(n), Space：O(1)
    public int rob(int[] nums) {
        if (nums == null | nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob01(nums, 0, n - 2), rob01(nums, 1, n - 1));
    }

}
