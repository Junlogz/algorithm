package com.demo76_100;

/**
 * @author: JunLog
 * @Description: 581. 最短无序连续子数组
 * Date: 2022/8/25 9:45
 */
public class _89FindUnsortedSubarray {

    // Time：O(n), Space：O(1)
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int i = 0, j = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            max = Math.max(max, nums[k]);
            if (nums[k] != max) j = k;
            int p = n - 1 - k;
            min = Math.min(min, nums[p]);
            if (nums[p] != min) i = p;
        }
        return j - i + 1;
    }

}
